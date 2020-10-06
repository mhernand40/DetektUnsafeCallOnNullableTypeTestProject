After cloning the project, run the following command:
```bash
./gradlew detektMain --continue
```

The task run should fail with the following exception:
```bash
> Task :android-library:detektDebug FAILED
Ignoring a file detekt cannot handle: path/to/project/DetektUnsafeCallOnNullableTypeTestProject/android-library/src/main/java/com/repro/JavaUser.java
potential-bugs - 40min debt
        UnsafeCallOnNullableType - [toPerson] at path/to/project/DetektUnsafeCallOnNullableTypeTestProject/android-library/src/main/java/com/repro/Adapter.kt:5:30
        UnsafeCallOnNullableType - [toPerson] at path/to/project/DetektUnsafeCallOnNullableTypeTestProject/android-library/src/main/java/com/repro/Adapter.kt:9:30

Overall debt: 40min


> Task :android-library:detektRelease FAILED
Ignoring a file detekt cannot handle: path/to/project/DetektUnsafeCallOnNullableTypeTestProject/android-library/src/main/java/com/repro/JavaUser.java
potential-bugs - 40min debt
        UnsafeCallOnNullableType - [toPerson] at path/to/project/DetektUnsafeCallOnNullableTypeTestProject/android-library/src/main/java/com/repro/Adapter.kt:5:30
        UnsafeCallOnNullableType - [toPerson] at path/to/project/DetektUnsafeCallOnNullableTypeTestProject/android-library/src/main/java/com/repro/Adapter.kt:9:30

Overall debt: 40min


> Task :jvm-library:detektMain FAILED
Ignoring a file detekt cannot handle: path/to/project/DetektUnsafeCallOnNullableTypeTestProject/jvm-library/src/main/java/com/repro/JavaUser.java
potential-bugs - 40min debt
        UnsafeCallOnNullableType - [toPerson] at path/to/project/DetektUnsafeCallOnNullableTypeTestProject/jvm-library/src/main/java/com/repro/Adapter.kt:5:30
        UnsafeCallOnNullableType - [toPerson] at path/to/project/DetektUnsafeCallOnNullableTypeTestProject/jvm-library/src/main/java/com/repro/Adapter.kt:9:30

Overall debt: 40min


FAILURE: Build completed with 3 failures.
```

This is expected as the project uses the double bangs operator (`!!`) on a nullable type.
Now try and suppress the error by generating baselines for the `detektMain` run.
```bash
./gradlew detektBaselineMain
```

Once that completes, re-run:
```bash
./gradlew detektMain --continue
```

**Expected:**
The run should succeed.