# Change Log
All notable changes to this project will be documented in this file.
This project adheres to [Semantic Versioning](http://semver.org/).

## [0.3.0] - 

### Added
- Syntactic sugar to assert an element state from a query ([#6]) 
- Syntactic sugar to assert an element property value from a query ([#7])
- Wrapped WebDriver is now accessible from the Browser, in case you need it ([#9])
- Submitting a form element ([#10])
- Action to clear the element text ([#11]) 
- Asserting an element attribute value ([#12])
- Asserting an element css property value ([#13])

### Changed
- It's now possible to type any sequence of chars, not only strings ([#5])
- Remove `probe` from public API of the element driver since it's part of its internals
- Working with a nested element now selects the element lazily and provides a better diagnostics
message ([#8])
- Improve diagnostics messages for all probes to make them more meaningful
- Moving the mouse and clicking are now two separate gestures that can be combined
- Update to Buildr 1.5 for the build system

### Fixed
- Eliminate superfluous space character in element manipulation description

## [0.2] - 2016-09-30

### Added
- Ability to select nested web elements ([#1])
- Text entry on an element using the keyboard ([#2])
- Ability to query a web element for a property, without asserting ([#3])

### Changed
- Clicking on an element using the mouse will now wait for the element to be clickable, i.e. visible and enabled ([#4])

### Fixed
- Stale elements are now longer reported as found when probing

## 0.1 - 2016-06-16

Initial public release


[0.3.0]: https://github.com/testinfected/mario/compare/v0.3.0...v0.2
[0.2]: https://github.com/testinfected/mario/compare/v0.2...v0.1

[#1]: https://github.com/testinfected/mario/issues/1
[#2]: https://github.com/testinfected/mario/issues/2
[#3]: https://github.com/testinfected/mario/issues/3
[#4]: https://github.com/testinfected/mario/issues/4
[#5]: https://github.com/testinfected/mario/issues/5
[#6]: https://github.com/testinfected/mario/issues/6
[#7]: https://github.com/testinfected/mario/issues/7
[#8]: https://github.com/testinfected/mario/issues/8
[#9]: https://github.com/testinfected/mario/issues/9
[#10]: https://github.com/testinfected/mario/issues/10
[#11]: https://github.com/testinfected/mario/issues/11
[#12]: https://github.com/testinfected/mario/issues/12
[#13]: https://github.com/testinfected/mario/issues/13