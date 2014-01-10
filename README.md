Android App Addicts
=======================


Gradle Notes
------------

* To build use: `gradlew clean build`

* To run sonar analysis: `gradlew sonarRunner`

* To run Android Tests (vanilla, Robotium, etc) `gradlew connectedInstrumentTest`

* To update the licenses: `gradlew licenseFormatMain licenseFormatTest licenseFormatInstrumentTest`


Git Notes
---------
* To add the subtree's the first time, see README_FIRST.md

* Contributing module changes back to upstream
    * Add YOUR repo as a remote (change the XXX) `git remote add XXX-AndroidViewUtils git@github
    .com:XXX/AndroidViewUtils.git`
    * Push the changes to YOUR fork `git subtree push --prefix modules/AndroidViewUtils
    XXX-AndroidViewUtils master`
    * Submit a Pull Request

* Update a module to the latest version
`git fetch AndroidViewUtils master`
`git subtree pull --prefix modules/AndroidViewUtils AndroidViewUtils master --squash`

