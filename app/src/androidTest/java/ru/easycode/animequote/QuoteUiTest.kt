package ru.easycode.animequote

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.easycode.presentation.MainActivity
import ru.easycode.presentation.R

@RunWith(AndroidJUnit4::class)
class QuoteUiTest {

    @get:Rule
    val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test() {
        Espresso.onView(withId(R.id.mainTextView)).check(matches(withText("no internet connection")))
        scenarioRule.scenario.recreate()
        Espresso.onView(withId(R.id.mainTextView)).check(matches(withText("mock quote")))
    }
}