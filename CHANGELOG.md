# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)

## [v1.3.1] - 2020-06-10

### Fixed

- **CUMULUS-2017** - fixed the `AdapterLogger` timestamp to be in ISO format

## [v1.3.0] - 2020-02-10

### BREAKING CHANGES

- Updated external CMA call to utilize python3 in anticipation of updates to the CMA.

This is a breaking change as it requires the existence of a `python3` runtime in the environment, similar to AWS's lambda runtime for Java8

## [v1.2.13] - 2020-01-02

### Added

- Added `JsonUtils` class to help with converting from a JSON string to a `Map` with proper type assignment
  - `JsonUtils.toMap()` converts JSON string to a `Map`

## [v1.2.12] - 2019-12-17

### Changed

- Updated `MessageParser.HandleMessage()` to properly handle errors where `e.getMessage()` is `null`, such as a `NullPointerException`

## [v1.2.11] - 2019-11-15

### Added

- CUMULUS-1634 - Adds three new keys `granules`, `parentArn`, and `stackName` to the AdapterLogger class

## [v1.2.10] - 2019-10-03

### Added

- CUMULUS-1488 - Update java client to allow use of CUMULUS_MESSAGE_ADAPTER_DIR environment variable/support layers

## [v1.2.9] - 2019-09-16

### Added

- Updated CMA client to handle parameterized configuration, set execution env variable regardless of message format
