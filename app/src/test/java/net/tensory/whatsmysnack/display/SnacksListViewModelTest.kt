package net.tensory.whatsmysnack.display

import android.arch.core.executor.testing.InstantTaskExecutorRule
import net.tensory.whatsmysnack.display.models.Snack
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
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

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Test
    fun data_withOneTypeSelected_onlyThatTypeIncluded () {
        viewModel.showVeggies = true
        viewModel.showNonVeggies = false

        assertThat(viewModel.snacks.value?.all { snack -> snack.type == Snack.Type.VEGGIE })
    }

    @Test
    fun data_withZeroTypesSelected_noDataIncluded () {
        viewModel.showVeggies = false
        viewModel.showNonVeggies = false

        assertThat(viewModel.snacks.value?.isEmpty())
    }
}