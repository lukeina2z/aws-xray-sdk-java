/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.xray.strategy.sampling.manifest;

import com.amazonaws.xray.strategy.sampling.GetSamplingRulesResponse.SamplingRule;
import com.amazonaws.xray.strategy.sampling.GetSamplingTargetsRequest.SamplingStatisticsDocument;
import com.amazonaws.xray.strategy.sampling.SamplingRequest;
import com.amazonaws.xray.strategy.sampling.rand.RandImpl;
import com.amazonaws.xray.strategy.sampling.rule.CentralizedRule;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.powermock.reflect.Whitebox;

class CentralizedManifestTest {

    @Test
    void testEmptyManifestSize() {
        CentralizedManifest manifest = new CentralizedManifest();
        Assertions.assertEquals(0, manifest.size());
    }

    @Test
    void testExpirationForNewManifest() {
        Instant now = Instant.ofEpochSecond(1500000000);

        CentralizedManifest manifest = new CentralizedManifest();
        Assertions.assertTrue(manifest.isExpired(now));
    }

    @Test
    void testExpirationForNewlyRefreshedManifest() {
        Instant now = Instant.ofEpochSecond(1500000000);

        CentralizedManifest manifest = new CentralizedManifest();
        SamplingRule r1 = rule(new RuleParams("r1"));
        manifest.putRules(Arrays.asList(r1), now);

        Assertions.assertFalse(manifest.isExpired(now));
    }

    @Test
    void testExpirationForOldManifest() {
        Instant now = Instant.ofEpochSecond(1500000000);

        CentralizedManifest manifest = new CentralizedManifest();
        SamplingRule r1 = rule(new RuleParams("r1"));
        manifest.putRules(Arrays.asList(r1), now);

        // Increment time to be one second past expiration
        now = Instant.ofEpochSecond(1500003601);

        Assertions.assertTrue(manifest.isExpired(now));
    }

    @Test
    void testPositiveMatch() {
        Instant now = Instant.ofEpochSecond(1500000000);

        CentralizedManifest manifest = new CentralizedManifest();

        SamplingRule r1 = SamplingRule.create(null, 0.05, "*", "*", 10,
             20, "*", null, "r1", "*", "*", "*", null);

        manifest.putRules(Arrays.asList(r1), now);

        SamplingRequest req = new SamplingRequest(
            "privileged",
            "resourceARN",
            "service",
            "host",
            "method",
            "url",
            "serviceType",
            null
        );

        Assertions.assertEquals("r1", manifest.match(req, now).sample(now).getRuleName().get());
    }

    @Test
    void testPositiveDefaultRuleMatch() {
        Instant now = Instant.ofEpochSecond(1500000000);

        CentralizedManifest manifest = new CentralizedManifest();

        SamplingRule r2 = SamplingRule.create(null, 0.05, null, null, 10, 20,
             null, null, CentralizedRule.DEFAULT_RULE_NAME, null, null, null, null);

        manifest.putRules(Arrays.asList(rule(new RuleParams("r1")), r2), now);

        // Request that matches against the default rule
        SamplingRequest req = new SamplingRequest(
            "privileged",
            "resourceARN",
            "service",
            "host",
            "method",
            "url",
            "serviceType",
            null
        );

        Assertions.assertEquals(CentralizedRule.DEFAULT_RULE_NAME, manifest.match(req, now).sample(now).getRuleName().get());
    }

    @Test
    void testPutRules() {
        Instant now = Instant.ofEpochSecond(1500000000);

        CentralizedManifest manifest = new CentralizedManifest();

        // Liberal sampling rule
        SamplingRule r1 = SamplingRule.create(null, 0.05, "*", "*", 10, 20,
             "*", null, "r1", "*", "*", "*", null);

        manifest.putRules(Arrays.asList(r1), now);

        SamplingRequest req = new SamplingRequest(
            "privileged",
            "resourceARN",
            "service",
            "host",
            "method",
            "url",
            "serviceType",
            null
        );

        Assertions.assertEquals("r1", manifest.match(req, now).sample(now).getRuleName().get());
    }

    @Test
    void testRebuildOnNewRule() {
        CentralizedManifest manifest = new CentralizedManifest();

        manifest.putRules(Arrays.asList(rule(new RuleParams("r1"))), Instant.now());
        Map<String, CentralizedRule> rules1 = Whitebox.getInternalState(manifest, "rules", CentralizedManifest.class);

        manifest.putRules(Arrays.asList(rule(new RuleParams("r1")), rule(new RuleParams("r2"))), Instant.now());
        Map<String, CentralizedRule> rules2 = Whitebox.getInternalState(manifest, "rules", CentralizedManifest.class);

        // The map of rules should be rebuilt, resulting in a new object
        Assertions.assertFalse(rules1 == rules2);

        Assertions.assertEquals(1, rules1.size());
        Assertions.assertEquals(2, rules2.size());
    }

    @Test
    void testPutRulesWithoutRebuild() {
        CentralizedManifest manifest = new CentralizedManifest();

        manifest.putRules(Arrays.asList(rule(new RuleParams("r1"))), Instant.now());
        Map<String, CentralizedRule> rules1 = Whitebox.getInternalState(manifest, "rules", CentralizedManifest.class);

        RuleParams params = new RuleParams("r1");
        params.resourceArn = "arn3";
        SamplingRule r = rule(params);

        manifest.putRules(Arrays.asList(r), Instant.now());
        Map<String, CentralizedRule> rules2 = Whitebox.getInternalState(manifest, "rules", CentralizedManifest.class);

        // The map of rules should not have been rebuilt
        Assertions.assertTrue(rules1 == rules2);
    }

    @Test
    void testRebuildOnPriorityChange() {
        CentralizedManifest manifest = new CentralizedManifest();

        RuleParams paramsFoo = new RuleParams("r1");
        manifest.putRules(Arrays.asList(rule(paramsFoo)), Instant.now());
        Map<String, CentralizedRule> rules1 = Whitebox.getInternalState(manifest, "rules", CentralizedManifest.class);

        RuleParams paramsBar = new RuleParams("r1");
        paramsBar.priority = 200;
        SamplingRule r = rule(paramsBar);

        manifest.putRules(Arrays.asList(r), Instant.now());
        Map<String, CentralizedRule> rules2 = Whitebox.getInternalState(manifest, "rules", CentralizedManifest.class);

        // The map of rules should be rebuilt, resulting in a new object
        Assertions.assertFalse(rules1 == rules2);

        Assertions.assertEquals(1, rules1.size());
        Assertions.assertEquals(1, rules2.size());
    }

    @Test
    void testRebuildOnRuleDeletion() {
        CentralizedManifest manifest = new CentralizedManifest();

        RuleParams paramsR1 = new RuleParams("r1");
        RuleParams paramsR2 = new RuleParams("r2");
        manifest.putRules(Arrays.asList(rule(paramsR1), rule(paramsR2)), Instant.now());
        Map<String, CentralizedRule> rules1 = Whitebox.getInternalState(manifest, "rules", CentralizedManifest.class);

        manifest.putRules(Arrays.asList(rule(paramsR2)), Instant.now());
        Map<String, CentralizedRule> rules2 = Whitebox.getInternalState(manifest, "rules", CentralizedManifest.class);

        // The map of rules should be rebuilt, resulting in a new object
        Assertions.assertFalse(rules1 == rules2);

        Assertions.assertEquals(2, rules1.size());
        Assertions.assertEquals(1, rules2.size());
    }

    @Test
    void testManifestSizeWithDefaultRule() {
        CentralizedManifest m = new CentralizedManifest();

        SamplingRule r2 = SamplingRule.create(null, 0.05, null, null, 1000, 20,
             null, null, CentralizedRule.DEFAULT_RULE_NAME, null, null, null, null);

        RuleParams paramsR1 = new RuleParams("r1");
        m.putRules(Arrays.asList(rule(paramsR1), r2), Instant.now());

        Assertions.assertEquals(2, m.size());
    }

    @Test
    void testManifestSizeWithoutDefaultRule() {
        CentralizedManifest m = new CentralizedManifest();

        SamplingRule r1 = SamplingRule.create(null, 0.05, null, null, 10, 20,
            null, null, CentralizedRule.DEFAULT_RULE_NAME, null, null, null, null);

        m.putRules(Arrays.asList(r1), Instant.now());

        Assertions.assertEquals(1, m.size());
    }

    @Test
    void testSnapshotsWithDefaultRule() {
        Instant now = Instant.ofEpochSecond(1500000000);

        CentralizedManifest m = new CentralizedManifest();
        RuleParams paramsR1 = new RuleParams("r1");
        RuleParams paramsR2 = new RuleParams("r2");
        RuleParams paramsR3 = new RuleParams(CentralizedRule.DEFAULT_RULE_NAME);
        m.putRules(Arrays.asList(
            rule(paramsR1),
            rule(paramsR2),
            rule(paramsR3)
        ), now);

        Map<String, CentralizedRule> rules = Whitebox.getInternalState(m, "rules", CentralizedManifest.class);
        CentralizedRule defaultRule = Whitebox.getInternalState(m, "defaultRule", CentralizedManifest.class);

        rules.forEach((key, r) -> r.sample(now));
        defaultRule.sample(now);

        List<SamplingStatisticsDocument> snapshots = m.snapshots(now);

        Assertions.assertEquals(3, snapshots.size());
    }

    @Test
    void testSnapshotsWithoutDefaultRule() {
        Instant now = Instant.ofEpochSecond(1500000000);

        CentralizedManifest m = new CentralizedManifest();
        RuleParams paramsR1 = new RuleParams("r1");
        RuleParams paramsR2 = new RuleParams("r2");
        m.putRules(Arrays.asList(
            rule(paramsR1),
            rule(paramsR2)
        ), now);

        Map<String, CentralizedRule> rules = Whitebox.getInternalState(m, "rules", CentralizedManifest.class);
        rules.forEach((key, r) -> r.sample(now));

        List<SamplingStatisticsDocument> snapshots = m.snapshots(now);

        Assertions.assertEquals(2, snapshots.size());
    }

    @Test
    void testRebuild() {
        Map<String, CentralizedRule> rules = new HashMap<>();
        RuleParams paramsFooR1 = new RuleParams("r1");
        paramsFooR1.priority = 11;
        RuleParams paramsFooR2 = new RuleParams("r2");
        rules.put("r1", new CentralizedRule(rule(paramsFooR1), new RandImpl()));
        rules.put("r2", new CentralizedRule(rule(paramsFooR2), new RandImpl()));

        List<SamplingRule> inputs = new ArrayList<>();
        RuleParams paramsBarR1 = new RuleParams("r1");
        RuleParams paramsBarR2 = new RuleParams("r2");
        RuleParams paramsBarR3 = new RuleParams("r3");
        inputs.add(rule(paramsBarR1));
        inputs.add(rule(paramsBarR2));
        inputs.add(rule(paramsBarR3));

        CentralizedManifest m = new CentralizedManifest();
        Map<String, CentralizedRule> rebuiltRules = m.rebuild(rules, inputs);

        Assertions.assertEquals(3, rebuiltRules.size());

        String[] orderedList = new String[3];
        rebuiltRules.keySet().toArray(orderedList);

        Assertions.assertEquals("r2", orderedList[0]);
        Assertions.assertEquals("r3", orderedList[1]);
        Assertions.assertEquals("r1", orderedList[2]);
    }

    static class RuleParams {
        public String name;
        public int priority = 10;
        public int reservoirSize = 20;
        public double fixedRate = 0.05;
        public String host = "*";
        public String serviceName = "s2";
        public String httpMethod = "POST";
        public String urlPath = "/foo";
        public String resourceArn = "arn2";

        RuleParams(String ruleName) {
            name = ruleName;
        }
    }

    private SamplingRule rule(RuleParams params) {
        SamplingRule r = SamplingRule.create(null, params.fixedRate,
            params.host, params.httpMethod, params.priority, params.reservoirSize, params.resourceArn, null,
            params.name, params.serviceName, null, params.urlPath, null);

        return r;
    }

}
