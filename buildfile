require 'buildr/gpg'
require 'buildr/jacoco'

VERSION_NUMBER = "0.3.2"

Release.commit_message = lambda { |version| "Bump version number to #{version}" }
Release.tag_name = lambda { |version| "v#{version}" }

define 'mario', :group => 'com.vtence.mario', :version => VERSION_NUMBER do
  compile.options.source = '1.8'
  compile.options.target = '1.8'

  compile.with :hamcrest, :selenium_api
  test.with :junit, :hamcrest_junit, transitive(artifacts(:selenium_firefox_driver))

  package :jar
  package :javadoc
  package :sources

  pom.name = 'Mario'
  pom.description = 'An Asynchronous WebDriver for Selenium'
  pom.add_mit_license
  pom.add_github_project('testinfected/mario')
  pom.scm_developer_connection = 'scm:hg:git+ssh://git@github.com:testinfected/mario.git'
  pom.add_developer('testinfected', 'Vincent Tence', 'vtence@gmail.com', ['Developer'])
end
