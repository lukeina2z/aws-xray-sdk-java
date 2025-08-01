# Change Log

## 2.18.3 - 2025-07-23
- Handle unknown fields in sampler APIs response. (#425) 
  [PR 425](https://github.com/aws/aws-xray-sdk-java/pull/425)

## 2.18.2 - 2024-08-19
- Update aws-java-sdk-xray version dependency. (#413) 
  [PR 413](https://github.com/aws/aws-xray-sdk-java/pull/413)

## 2.18.1 - 2024-08-09
- Remove testing logs (#411)
  [PR 411](https://github.com/aws/aws-xray-sdk-java/pull/411)

## 2.18.0 - 2024-08-07
- Support Lambda PassThrough trace header propagation (#409)
  [PR 409](https://github.com/aws/aws-xray-sdk-java/pull/409)

## 2.17.0 - 2024-07-12
- Revert aws#403 and aws#404
  [PR 407](https://github.com/aws/aws-xray-sdk-java/pull/407)

## 2.16.0 - 2024-05-28
- Send NoOp segment when trace header is incomplete in Lambda Context
  [PR 403](https://github.com/aws/aws-xray-sdk-java/pull/403)
- Do not propagate trace header if dummy subsegment
  [PR 404](https://github.com/aws/aws-xray-sdk-java/pull/404)

## 2.15.3 - 2024-04-25
- Bump aws-java-sdk-core version to 1.12.708
  [PR 401](https://github.com/aws/aws-xray-sdk-java/pull/401)

## 2.15.2 - 2024-03-08
- Fixed TracingInterceptor to take effect only one time
  [PR 399](https://github.com/aws/aws-xray-sdk-java/pull/399)

## 2.15.1 - 2024-02-15
- Fixing S3 bucket name extraction for AWS SDK V2
  [PR 393](https://github.com/aws/aws-xray-sdk-java/pull/393)

## 2.15.0 - 2023-12-07
- Remove usage of deprecated jackson property
  [PR 391](https://github.com/aws/aws-xray-sdk-java/pull/391)
- Optimize default resolver chain construction
  [PR 387](https://github.com/aws/aws-xray-sdk-java/pull/387)
- Refactored AWSXRayServletFilter - not to use deprecated method for strategy creation
  [PR 386](https://github.com/aws/aws-xray-sdk-java/pull/386)
- Bumping grgit version
  [PR 385](https://github.com/aws/aws-xray-sdk-java/pull/385)
- Use jackson to snake case for better performance
  [PR 382](https://github.com/aws/aws-xray-sdk-java/pull/382)
- Thread safety
  [PR 383](https://github.com/aws/aws-xray-sdk-java/pull/383)

## 2.14.0 - 2023-04-13
- Add support for Jakarta and Spring 6
[PR 372](https://github.com/aws/aws-xray-sdk-java/pull/372)
- Fix sqs/sns case for aws sdk v2 parameter allowlist lookups
[PR 373](https://github.com/aws/aws-xray-sdk-java/pull/373)
- Fixing NoClassDefFoundError
[PR 375](https://github.com/aws/aws-xray-sdk-java/pull/375)

## 2.13.0 - 2022-11-08
- Oversampling Mitigation
[PR 356](https://github.com/aws/aws-xray-sdk-java/pull/356)
- Add back original subsegment noOp method
[PR 359](https://github.com/aws/aws-xray-sdk-java/pull/359)
- Adding back depricated functions
[PR 360](https://github.com/aws/aws-xray-sdk-java/pull/360)
- Refactoring TraceHeader Calls
[PR 361](https://github.com/aws/aws-xray-sdk-java/pull/361)

## 2.12.0 - 2022-10-07
- Allow list TopicArn for SNS Publish and PublishBatch
[PR 357](https://github.com/aws/aws-xray-sdk-java/pull/357)
- Oversampling mitigation
[PR 354](https://github.com/aws/aws-xray-sdk-java/pull/354)
- Change missing context default behavior to log error
[PR 353](https://github.com/aws/aws-xray-sdk-java/pull/353)
- Revert subsegment synchronization changes
[PR 350](https://github.com/aws/aws-xray-sdk-java/pull/350)
- Update README with manual configuration for log groups
[PR 349](https://github.com/aws/aws-xray-sdk-java/pull/349)
- Add Nullable annotation to AWSXray.setTraceEntity() parameter
[PR 345](https://github.com/aws/aws-xray-sdk-java/pull/345)
- Add javadoc to Subsegment.close() method
[PR 342](https://github.com/aws/aws-xray-sdk-java/pull/342)
- Send subsegments separately from segments when the serialized size is larger than the UDP packet size limit
[PR 344](https://github.com/aws/aws-xray-sdk-java/pull/344)
- Improve the emitter sendData failure log message
[PR 343](https://github.com/aws/aws-xray-sdk-java/pull/343)
- Throw ClientProtocolException instead of returning null to avoid possible NPE in Apache HTTP instrumentation
[PR 338](https://github.com/aws/aws-xray-sdk-java/pull/338)

## 2.11.2 - 2022-06-02
- Upgrade AWS Java SDK to 1.12.228
[PR 334](https://github.com/aws/aws-xray-sdk-java/pull/334)
- Revert some dependency versioning. Set duplicatesStrategy for benchmark project.
[PR 336](https://github.com/aws/aws-xray-sdk-java/pull/336)

## 2.11.1 - 2022-04-06
- Update Spring dependencies to address cve-2022-22965
[PR 329](https://github.com/aws/aws-xray-sdk-java/pull/329)

## 2.11.0 - 2022-02-02
- Update log4j to 2.17 to address CVE-2021-45105
[PR 314](https://github.com/aws/aws-xray-sdk-java/pull/314)
- Adding GraalVM native-image config
[PR 311](https://github.com/aws/aws-xray-sdk-java/pull/311)
- Reduce log level of sampling error logging
[PR 309](https://github.com/aws/aws-xray-sdk-java/pull/309)

## 2.10.0 - 2021-10-19
- Optimize the lock in segment
[PR 306](https://github.com/aws/aws-xray-sdk-java/pull/306)
- Optimize the regex in util method
[PR 305](https://github.com/aws/aws-xray-sdk-java/pull/305)
- Add Automatic-Module-Name to JAR Manifest
[PR 297](https://github.com/aws/aws-xray-sdk-java/pull/297)
- Improvements to no-op subsegment behavior
[PR 294](https://github.com/aws/aws-xray-sdk-java/pull/294)
- Prevent crashes on serializing empty beans
[PR 293](https://github.com/aws/aws-xray-sdk-java/pull/293)
- Opt-in support to collect SQL queries
[PR 283](https://github.com/aws/aws-xray-sdk-java/pull/283)

## 2.9.1 - 2021-06-02
- Improve handling of entity `emitted` field
[PR 279](https://github.com/aws/aws-xray-sdk-java/pull/279)
- Remove global subsegment lock to fix race condition
[PR 278](https://github.com/aws/aws-xray-sdk-java/pull/278)
- Updated Apache HTTP and AWS SDK versions
[PR 277](https://github.com/aws/aws-xray-sdk-java/pull/277)

## 2.9.0 - 2021-04-08
- Added aggregate javadoc plugin
[PR 242](https://github.com/aws/aws-xray-sdk-java/pull/242)
- Configurtion to always create trace ID
[PR 243](https://github.com/aws/aws-xray-sdk-java/pull/243)
- Fix sampling rules not being deleted
[PR 244](https://github.com/aws/aws-xray-sdk-java/pull/244)
- Lock accesses to entities
[PR 250](https://github.com/aws/aws-xray-sdk-java/pull/250)
- Added support for reading header from environment and system properties
[PR 252](https://github.com/aws/aws-xray-sdk-java/pull/252)
- Added log correlation support to ECS plugin
[PR 263](https://github.com/aws/aws-xray-sdk-java/pull/263)
- Added JavaTimeModule for entity object mapper
[PR 267](https://github.com/aws/aws-xray-sdk-java/pull/267)
- Addded enhanced metadata parsing for Oracle DBs
[PR 270](https://github.com/aws/aws-xray-sdk-java/pull/270)
- Added support to set log group via environment variable
[PR 273](https://github.com/aws/aws-xray-sdk-java/pull/273)


## 2.8.0 - 2020-11-24
- Optimized creating, parsing, and serializing trace IDs
[PR 212](https://github.com/aws/aws-xray-sdk-java/pull/212)
- Fixed setParent behavior for NoOp subsegments
[PR 215](https://github.com/aws/aws-xray-sdk-java/pull/215)
- Added a faster random source configuration
[PR 218](https://github.com/aws/aws-xray-sdk-java/pull/218)
- Lowered log level on IMDS error messages
[PR 219](https://github.com/aws/aws-xray-sdk-java/pull/219)
- Removed nanosecond-time resolution where unneeded for performance
[PR 224](https://github.com/aws/aws-xray-sdk-java/pull/224)
- Fixed log error context missing strategy stack traces
[PR 235](https://github.com/aws/aws-xray-sdk-java/pull/235)
- Added isForcedSampling support configurability to sampling strategies
[PR 232](https://github.com/aws/aws-xray-sdk-java/pull/232)
- Add top-level method for context-free endSubsegment
[PR 229](https://github.com/aws/aws-xray-sdk-java/pull/229)
- Add ThreadLocal-safe Entity.run() method
[PR 240](https://github.com/aws/aws-xray-sdk-java/pull/240)

## 2.7.1 - 2020-08-28
- Fix ClassCastException caused by change in 2.7.0
[PR 202](https://github.com/aws/aws-xray-sdk-java/pull/202)
- Add rule_name attribute to segments made with beginSegmentWithSampling
[PR 204](https://github.com/aws/aws-xray-sdk-java/pull/204)

## 2.7.0 - 2020-08-25
- Add beginSegmentWithSampling API
[PR 196](https://github.com/aws/aws-xray-sdk-java/pull/196)
- Changed containerId to container_id in ECS plugin
[PR 195](https://github.com/aws/aws-xray-sdk-java/pull/195)
- Improved performance of withDefaultPlugins
[PR 194](https://github.com/aws/aws-xray-sdk-java/pull/194)
- Reduced timeout and logging from IMDS failure
[PR 192](https://github.com/aws/aws-xray-sdk-java/pull/192)
- Debug log the stacktrace for LOG_ERROR strategy
[PR 191](https://github.com/aws/aws-xray-sdk-java/pull/191)
- Made SqlSubsegments class exception-safe
[PR 189](https://github.com/aws/aws-xray-sdk-java/pull/189)
- Added utility class for creating SQL subsegments
[PR 186](https://github.com/aws/aws-xray-sdk-java/pull/186)
- Deprecated Dummy(Sub)Segments in favor of NoOps
[PR 183](https://github.com/aws/aws-xray-sdk-java/pull/183)
- Return no-op segments instead of null when context isn't found
[PR 180](https://github.com/aws/aws-xray-sdk-java/pull/180)
- Fixed behavior of exception throwing on invalid address in DaemonConfig
[PR 179](https://github.com/aws/aws-xray-sdk-java/pull/179)
- Fixed bug where subsegments operations used a different lock
[PR 182](https://github.com/aws/aws-xray-sdk-java/pull/182)
- Changed AWS SDKs to runtime dependencies in AWS SDK instrumentation modules
[PR 167](https://github.com/aws/aws-xray-sdk-java/pull/167)

## 2.6.1 - 2020-06-20
- Fixed JSON parsing logic for Centralized Sampling
[PR 171](https://github.com/aws/aws-xray-sdk-java/pull/171)

## 2.6.0 - 2020-06-10
- Added calls to X-Ray daemon for rules/targets with a simple JDK-based client
[PR 145](https://github.com/aws/aws-xray-sdk-java/pull/145)
- Added a public API for creating Emitter without exposing implementation details
[PR 146](https://github.com/aws/aws-xray-sdk-java/pull/146)
- Exposed sampling manifest URL for testing
[PR 149](https://github.com/aws/aws-xray-sdk-java/pull/149)
- Added utility executors for context propagation
[PR 150](https://github.com/aws/aws-xray-sdk-java/pull/150)
- Modified exception handling in UDPEmitter
[PR 151](https://github.com/aws/aws-xray-sdk-java/issues/151)
- Added more safety in UnsignedXrayClient
[PR 154](https://github.com/aws/aws-xray-sdk-java/pull/154)
- Added IMDSv2 Support
[PR 155](https://github.com/aws/aws-xray-sdk-java/pull/155)
- Applied checkstyle and prepare for license header check
[PR 156](https://github.com/aws/aws-xray-sdk-java/pull/156)
- Avoid String.split when parsing header to reduce garbage generation
[PR 160](https://github.com/aws/aws-xray-sdk-java/pull/160)
- Modified support for allocate new traceID when traceID parse fail
[PR 161](https://github.com/aws/aws-xray-sdk-java/pull/161)
- Use singleton SecureRandom
[PR 162](https://github.com/aws/aws-xray-sdk-java/pull/162)

## 2.5.0 - 2020-05-11
- Added Spring interceptor without Spring data dependency
[PR 115](https://github.com/aws/aws-xray-sdk-java/pull/115)
- Handled null responses in sampling API requests
[PR 122](https://github.com/aws/aws-xray-sdk-java/pull/122)
- Fix NPE while handling LOG_ERROR in Spring module
[PR 125](https://github.com/aws/aws-xray-sdk-java/pull/125)
- Support trace ID injection during context propagation
[PR 127](https://github.com/aws/aws-xray-sdk-java/pull/127)
- Added IgnoreContextMissingStrategy
[PR 129](https://github.com/aws/aws-xray-sdk-java/pull/129)
- Fixed implementation of isWrapperFor and unwrap
[PR 131](https://github.com/aws/aws-xray-sdk-java/pull/131)
- Fixed subsegment streaming in Lambda
[PR 133](https://github.com/aws/aws-xray-sdk-java/pull/133)
- Added fully qualified & configurable trace ID injection
[PR 135](https://github.com/aws/aws-xray-sdk-java/pull/135)
- Fixed implementation of TracingStatement when no segment present
[PR 137](https://github.com/aws/aws-xray-sdk-java/pull/137)
- Improved Docker ID discovery in DockerUtils
[PR 141](https://github.com/aws/aws-xray-sdk-java/pull/141)
- Performance improvements to equals and hashcode usages
[PR 142](https://github.com/aws/aws-xray-sdk-java/pull/142)

## 2.4.0 - 2019-11-21
- Fix tags in pom.xml
[PR 83](https://github.com/aws/aws-xray-sdk-java/pull/87)
- Add default protected constructor for HTTPClientBuilder
[PR 90](https://github.com/aws/aws-xray-sdk-java/pull/90)
- Add subtree streaming for subsegments
[PR 91](https://github.com/aws/aws-xray-sdk-java/pull/91)
- Add a benchmarking package for timing
[PR 75](https://github.com/aws/aws-xray-sdk-java/pull/75)
- Capture throwables instead of just errors in XRayServletFilter
[PR 100](https://github.com/aws/aws-xray-sdk-java/pull/100)
- Change sonatype endpoint to dedicated AWS one
[PR 105](https://github.com/aws/aws-xray-sdk-java/pull/105)
- Add generic SQL recorder module
[PR 107](https://github.com/aws/aws-xray-sdk-java/pull/107)
- Add support for segment-level metrics and integration with logs
[PR 110](https://github.com/aws/aws-xray-sdk-java/pull/110)
  - Add log4j module
  - Add slf4j module
  - Add metrics module
- Upgrade Maven Javadoc plugin & disable javadoc linting
[PR 111](https://github.com/aws/aws-xray-sdk-java/pull/111)

## 2.3.0 - 2019-07-18
- Add SNS service to AWS SDK operation whitelist JSON
[PR 85](https://github.com/aws/aws-xray-sdk-java/pull/85)
- Allow specification of Daemon configuration in UDPEmitter
[PR 80](https://github.com/aws/aws-xray-sdk-java/pull/80)
- Add support for JDK 11
[PR 78](https://github.com/aws/aws-xray-sdk-java/pull/78)
- Make TraceInterceptor.entityKey public
[PR 73](https://github.com/aws/aws-xray-sdk-java/pull/73)

## 2.2.1 - 2019-02-07
- Fixed BOM package to include new artifacts introduced in 2.2.0.

## 2.2.0 - 2019-02-07
- Fixed a race condition with sampling reservoir.
[PR 47](https://github.com/aws/aws-xray-sdk-java/pull/47)
- Cleaned up some duplicated code around handling context missing strategy.
[PR 50](https://github.com/aws/aws-xray-sdk-java/pull/50)
- Fixed a race condition with sampling reservoir that could lead to `IndexOutOfBoundsException`.
[PR 52](https://github.com/aws/aws-xray-sdk-java/pull/52)
- Fixed a race condition where the `AWSXRayServletFilter` would eagerly retrieve the global recorder on instantiation, causing custom recorders to sometimes be ignored.
[PR 53](https://github.com/aws/aws-xray-sdk-java/pull/53)
- Added support for instrumenting the AWS SDK for Java V2.
[PR 56](https://github.com/aws/aws-xray-sdk-java/pull/56)
- Fixed an issue where segments were not being cleaned up when servlets were processed asynchronously.
[PR 57](https://github.com/aws/aws-xray-sdk-java/pull/57)
- Fixed an issue where extra recorders were created when using `CentralizedSamplingStrategy` without a plugin setting an origin value.
[PR 59](https://github.com/aws/aws-xray-sdk-java/pull/59)

## 2.1.0 - 2018-11-20
- Fixed a race condition on sampling pollers start.
- The sampling pollers now also log `Error` in addition to `Exception`.
- Added a public API to `CentralizedSamplingStrategy` to shutdown pollers for clean exit.
- Fixed a race condition between `TracingHandler` and `AWSXRayRecorder` which could cause an NPE on AWS calls capture. [ISSUE29](https://github.com/aws/aws-xray-sdk-java/issues/29)
- Fixed a NPE bug in spring X-Ray interceptor when context is missing. [ISSUE41](https://github.com/aws/aws-xray-sdk-java/issues/41)
- Fixed a NPE bug in `DaemonConfig` when system property is used to set up the daemon address. [ISSUE40](https://github.com/aws/aws-xray-sdk-java/issues/40)
- Removed an unused dependency. [ISSUE39](https://github.com/aws/aws-xray-sdk-java/issues/39)
- Removed unnecessary credentials retrieval for AWS client used by sampling pollers. [PR34](https://github.com/aws/aws-xray-sdk-java/pull/34)
- Fixed the UDP address setter not work correctly on `DaemonConfig`.
- Catching an NPE when the SDK property file is not reachable on unit tests.

## 2.0.1 - 2018-09-06
### Changed
- Fixed a bug that caused XRay sampling rules fetching to fail when AWS SDK instrumentor is included. [ISSUE25](https://github.com/aws/aws-xray-sdk-java/issues/25)

## 2.0.0 - 2018-08-28
### Backwards incompatible change
- Default Sampling Strategy has been updated to Centralized Sampling Strategy which gets sampling rules from X-Ray backend instead of from a static JSON file. [More Information](https://docs.aws.amazon.com/xray/latest/devguide/xray-console-sampling.html)
- Implement two new class `RulePoller` and `TargetPoller` to periodically updating sampling rules and sampling targets through TCP connection.
- Fallback to Localized Sampling Strategy when centralized sampling rules are not available.
- In order to disable Centralized Sampling Strategy, provide `withSamplingStrategy` with Localized one.
- Update `DefaultSamplingRules.json` file. i.e. `service_name` has been replaced to `host` and `version` changed to `2`. SDK still supports `v1` JSON file. If `v1` version JSON has been provided, `shouldTrace` will treat `service_name` value as `host` value.
- Update `shouldTrace` method to take only one parameter defined in `samplingRequest`.
- Add a new class called `DaemonConfiguration` and both classes `UDPEmitter` and `XRayClient` are depending on it. `setDaemonAddress` method has been moved to class `DaemonConfiguration`.
### Added
- Environment variable `AWS_TRACING_DAEMON_ADDRESS` now takes a value of the form '127.0.0.1:2000' or 'tcp:127.0.0.1:2000 udp:127.0.0.2:2001'. The former one means UDP and TCP are running at the same address and the later one specify individual addresses for TCP and UDP connection. By default it assumes a X-Ray daemon running at 127.0.0.1:2000 listening to both UDP and TCP traffic.
- Update `DefaultOperationParameterWhitelist.json` with S3 support. [PR9](https://github.com/aws/aws-xray-sdk-java/pull/9)
- Update `README` with correct `defaultRecorder` method. [PR10](https://github.com/aws/aws-xray-sdk-java/pull/10)
- Link scorekeep sample application in `README`. [PR12](https://github.com/aws/aws-xray-sdk-java/pull/12)
- Add missing open sourcing standard files. [PR14](https://github.com/aws/aws-xray-sdk-java/pull/14)
- Add travis CI. [PR16](https://github.com/aws/aws-xray-sdk-java/pull/16)
- Update `getUrl` method do not concatenate if the url in request is already absolute. [PR20](https://github.com/aws/aws-xray-sdk-java/pull/20)

## 1.3.1 - 2018-01-12
### Changed
- Fixed a bug in `AbstractXRayInterceptor` so that `generateMetadata` can be overriden. [PR6](https://github.com/aws/aws-xray-sdk-java/pull/6)

## 1.3.0 - 2018-01-08
### Added
- Support for Spring Framework which enables the usage of aspects to trace requests down a call stack. Classes can either implement an interface or be annotated to identify themselves as available to the aspect for tracing. [PR1](https://github.com/aws/aws-xray-sdk-java/pull/1)

## 1.2.2 - 2017-12-05
### Changed
- Fixed a bug which caused certain non-sampled segments to be emitted to the X-Ray daemon. This issue occurred only when the segment began as sampled and was manually overridden to non-sampled using `setSampled(false)`.

## 1.2.1 - 2017-11-20
### Changed
- Fixed a bug in the exception serialization logic that occurred when an added exception had one or more 'cause' exceptions.

## 1.2.0 - 2017-08-11
### Added
- Additional methods added to the `SegmentContext` interface. The `SegmentContext` interface now supports overriding logic for beginning and ending a `Segment`. This allows customers to use an alternative to `ThreadLocal` values to pass `SegmentContext` throughout program execution.
### Changed
- Various string fixes.
- Exposed the exceptionless version of the `close()` method on the more generic `Entity` type. Generic types may now be used in try-with-resources blocks without requiring a `catch` block.
- Ignoring subsegment generation on S3 presign request API call.

## 1.1.2 - 2017-06-29
### Added
- Attempting to modify or re-emit a `Segment` now throws an unchecked `AlreadyEmittedException`.
### Changed
- Fixed a concurrent modification exception which occured when many exceptions were being added to a single subsegment at once.
- Various string fixes.

## 1.1.1 - 2017-05-17
### Added
- Configuration values set using the environment variables `AWS_XRAY_TRACING_NAME`, `AWS_XRAY_CONTEXT_MISSING`, and `AWS_XRAY_DAEMON_ADDRESS` can now also be set using Java system properties.
  - The corresponding property keys are `-Dcom.amazonaws.xray.strategy.tracingName`, `-Dcom.amazonaws.xray.strategy.contextMissingStrategy`, and `-Dcom.amazonaws.xray.emitters.daemonAddress` respectively.
  - Configuration values set using environment variables take precedence over those set using Java system properties, in turn taking precedence over any configuration values set in code.
### Changed
- Modification or re-emittance of segments or subsegments after they have already been emitted to the X-Ray daemon now results in an AlreadyModifiedException / log message (depending on the `ContextMissingStrategy` in use).

## 1.1.0 - 2017-04-19
### Added
- Support for tracing within AWS Lambda functions
- The provided AWSXRayServletFilter now supports asynchronous `HttpServletRequest`s

### Changed
- Subsegments representing calls to S3 that result in status codes 304 or 412 will no longer be considered as `fault`s.
- Information about the runtime environment (JVM name and version) is now added to segments under the `service` namespace.

## 1.0.6-beta - 2017-03-30
### Added
- Added an additional constructor to `DefaultThrowableSerializationStrategy` that allows overriding of the `Throwable` superclass types which are considered to be remote.
- Added more runtime information to the `aws.xray` namespace on segments.
- Added a `ContextMissingStrategy` member to the `AWSXRayRecorder` class. This allows configuration of the exception behavior exhibited when trace context is not properly propagated. The behavior can be configured in code. Alternatively, the environment variable `AWS_XRAY_CONTEXT_MISSING` can be used (overrides any modes set in code). Valid values for this environment variable are currently (case insensitive) `RUNTIME_ERROR` and `LOG_ERROR`. The default behavior remains, `DefaultContextMissingStrategy` extends `RuntimeErrorContextMissingStrategy`; i.e. by default, an exception will be thrown on missing context.
### Changed
- **BREAKING** Changed the `currentEntityId` and `currentTraceId` methods from static to instance-level methods, in order to have them support the configurable `contextMissingBehavior`.
### Removed
- **BREAKING** Removed support for the `XRAY_TRACING_NAME` environment variable.
- **BREAKING** Removed the use of `InheritableThreadLocal` values to store trace context, in favor of regular `ThreadLocal` values. This change was made to improve the safety of the way the SDK interacts with thread pools and other collections of long-lived threads.
- Removed behavior in which calls to `AWSXRayRecorder.getThreadLocal()` would throw a `SegmentNotFoundException` when the thread local value contained null. The method now returns null instead of throwing an exception.

## 1.0.5-beta - 2017-03-06
### Added
- Added the `getCurrentSegmentOptional` and `getCurrentSubsegmentOptional` methods to the `AWSXRay` and `AWSXRayRecorder` classes.
- Added pertinent parameters to subsegments wrapping AWS Lambda Invoke and InvokeAsync operations.
- Added the `beginDummySegment()` method to the `AWSXRay` class.

### Changed
- Changed the `sdk` key to `sdk_version` in the `aws.xray` segment property.
- Changed the `getCurrentSegment` method in the `AWSXRayRecorder` class to throw a `SegmentNotFoundException` if no segment is found.
- Changed the behavior of the `LocalizedSamplingStrategy` class to require that all loaded sampling rule JSON files include default `fixed_target` and `rate` values under the `default` namespace. The file must now be versioned, this release supports `"version": 1` of the sampling rules document.
  - An example is provided in `aws-xray-recorder-sdk-core/src/main/resources/com/amazonaws/xray/strategy/sampling/DefaultSamplingRules.json`.
- Changed the behavior of the `aws-xray-recorder-sdk-apache-http` submodule to flag its generated subsegments with error/throttle/fault values based on response codes received from downstream HTTP services.

### Removed
- Removed the `attribute_names_substituted` key that was previously added to subsegments wrapping some DynamoDB operations.
- Removed the single `URL` parameter constructor from the `DefaultSamplingStrategy` class. To pass a custom sampling rules file, use the `LocalizedSamplingStrategy`.

## 1.0.4-beta - 2017-02-13
### Changed
- Fixed a bug where the continuous injection of thread-local values to other threads caused a memory leak. This change removes the `TraceReference` class.
  - `AWSXRayRecorder.infectThreadLocal` is renamed to `AWSXRayRecorder.injectThreadLocal`.
  - `AWSXRayRecorder.getThreadLocal()` now returns an `Entity` rather than a `TraceReference`.
  - `AWSXRayRecorder.injectThreadLocal(Entity entity)` now accepts an `Entity` rather than a `TraceReference`.

## 1.0.3-beta - 2017-01-24
- No change

## 1.0.2-beta - 2017-01-24
### Added
- Added the `SegmentNamingStrategy` interface. Instantation of the `AWSXRayServletFilter` now requires an instance of `SegmentNamingStrategy`. A shorthand constructor which accepts a single `String` is also provided to simplify use of the `FixedSegmentNamingStrategy`.
- Added the `FixedSegmentNamingStrategy` and `DynamicSegmentNamingStrategy` strategies.

### Changed
- Fixed a bug in the behavior of the custom pattern generation used in sampling rules and the `DynamicNamingStrategy`.
- Changed the segment key under which the SDK version is recorded to "xray".
- Fixed a bug whereby segments with more than 100 subsegments were not properly being streamed to the service.
- Changed the behavior of the `setError` method in the `EntityImpl` class to no longer also modify the `fault` value.
- Changed the environment variable key to modify the target daemon address / port to `AWS_XRAY_DAEMON_ADDRESS`. The value is expected to be of the form `ip:port`.
- Changed the environment variable key to override the segment name from `XRAY_TRACING_NAME` to `AWS_XRAY_TRACING_NAME`. (`XRAY_TRACING_NAME` will still be supported until the non-beta release).
- Moved the `precursor_ids` property to be a member of only the `Subsegment` type.

## 1.0.1-beta - 2016-12-15
### Added
- Added the SDK version to generated segment documents.
- Added functionality to the `DummySegment` class in order to pass the Trace ID to downstream services in all cases, including those in which the current request is not sampled.

### Changed
- Fixed a bug in AWSXRayServletFilter that prevented the creation of subsegments for some services running behind ALBs.
- Updated the dependency on `com.amazonaws:aws-java-sdk-core` from version 1.11.60 to 1.11.67.
- Modified the signatures of the `close()` methods for `SegmentImpl` and `SubsegmentImpl` to not throw any exceptions.

### Removed
- Removed redundant HTTP status code parsing logic from the `apache-http` submodule. The AWS X-Ray service handles setting the fault, error, and throttle flags based on subsegments' provided HTTP status code.
