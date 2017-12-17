package net.tensory.whatsmysnack.display

import net.tensory.whatsmysnack.display.models.Snack
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

/**
 * Test data selection by property value.
 */
class SnacksListViewModelTest {
    private lateinit var viewModel: SnacksListViewModel

    @Before
    fun setUp() {
        viewModel = SnacksListViewModel()
    }

    @Test
    fun data_withOneTypeSelected_onlyThatTypeDisplayed() {
        viewModel.showVeggies = true
        viewModel.showNonVeggies = false

        assertThat(viewModel.snacks.all { snack -> snack.type == Snack.Type.VEGGIE })
    }
}