package net.tensory.whatsmysnack.display

import android.arch.core.executor.testing.InstantTaskExecutorRule
import net.tensory.whatsmysnack.data.SnackDataProvider
import net.tensory.whatsmysnack.data.SnackType
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks

/**
 * Test data selection by property value.
 */
class SnackListViewModelTest {
    private lateinit var viewModel: SnackListViewModel

    @InjectMocks lateinit var snackDataProvider: SnackDataProvider

    @Before
    fun setUp() {
        viewModel = SnackListViewModel(snackDataProvider)
    }

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Test
    fun data_withOneTypeSelected_onlyThatTypeIncluded () {
        viewModel.showVeggies = true
        viewModel.showNonVeggies = false

        assertThat(viewModel.snacks.value?.all { snack -> snack.type == SnackType.VEGGIE })
    }

    @Test
    fun data_withZeroTypesSelected_noDataIncluded () {
        viewModel.showVeggies = false
        viewModel.showNonVeggies = false

        assertThat(viewModel.snacks.value?.isEmpty())
    }
}