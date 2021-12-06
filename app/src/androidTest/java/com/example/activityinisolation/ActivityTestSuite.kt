package com.example.activityinisolation

import com.example.EspressoUITestExamples.MainActivityTest
import com.example.EspressoUITestExamples.SecondaryActivityTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    SecondaryActivityTest::class
)

class ActivityTestSuite {
}