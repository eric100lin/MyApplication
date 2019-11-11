package com.example.myapplication

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Rule @JvmField
    //Instructs the Kotlin compiler not to generate getters/setters for this property and
    // expose it as a field. like: public final ActivityTestRule<KotlinJni> activityRule;
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = getInstrumentation().targetContext
        assertEquals("com.example.myapplication", appContext.packageName)
    }

    @Test
    fun clickFloatingActionButton() {
        onView(withId(R.id.fab)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(R.string.snackbar_text)))
    }

    @Test
    fun clickItemsInActionBarOverflowOrOptionsMenu() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext())
        Thread.sleep(500)   // Sleep for animation done on MTK Android TV
        onView(withText(R.string.action_settings)).perform(click())
    }

    @Test
    fun noClickItemsInActionBarOverflowOrOptionsMenu() {
        val activity = activityRule.getActivity()
        activity.runTimeMenuItem.add("Another Item")
        activity.invalidateOptionsMenu()
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext())
        Thread.sleep(500)   // Sleep for animation done on MTK Android TV
        onView(withText("Another Item")).perform(click())
    }
}
