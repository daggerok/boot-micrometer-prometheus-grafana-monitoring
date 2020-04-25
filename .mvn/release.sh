#!/usr/bin/env bash

currentVersion=`./mvnw -q --non-recursive exec:exec -Dexec.executable=echo -Dexec.args='${project.version}'`

if [[ "$currentVersion" == *"SNAPSHOT"* ]] ; then
  ./mvnw clean release:prepare release:perform \
    -B -Dgoals='package' -DgenerateReleasePoms=false -DgenerateBackupPoms=false
else
  git tag "v$currentVersion"
  ./mvnw build-helper:parse-version -DgenerateBackupPoms=false -DgenerateBackupPoms=false versions:set \
    -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.nextIncrementalVersion}
  git add . ; git commit -am "v$currentVersion release." ; git push origin master --tags
fi
