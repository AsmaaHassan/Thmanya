package com.example.thmanya

/**
 * Created by AsmaaHassan on 25,August,2025
 * Cairo, Egypt.
 */
import com.example.thmanya.data.HomeSectionsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import com.example.thmanya.data.Section
import com.example.thmanya.domain.network.ApiService
import com.example.thmanya.domain.repository.HomeRepository

@RunWith(MockitoJUnitRunner::class)
class HomeRepositoryTest {

    // Mock the dependencies
    @Mock
    private lateinit var mockApiService: ApiService

    // The class we are testing
    private lateinit var homeRepository: HomeRepository

    // A test dispatcher to control coroutines
    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        // Initialize the repository with the mock dependencies
        homeRepository = HomeRepository(mockApiService)

        // Set the Main dispatcher to our test dispatcher
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        // Reset the Main dispatcher to its original state
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun getHomeSections_returnsSortedSections() = runTest {
        // 1. Arrange: Define the fake data and mock the API response.
        val unsortedSections = listOf(
            Section( name = "Bestselling Audiobooks", order = 3, type= "big_square", contentType = "audio_book", content = listOf()),
            Section( name = "Top Podcasts", order = 1, type= "square", contentType = "podcast", content = listOf()),
            Section( name = "Trending Episodes", order = 2, type= "2_lines_grid", contentType = "episode", content = listOf()),

        )
        val expectedSortedSections = listOf(
            Section( name = "Top Podcasts", order = 1, type= "square", contentType = "podcast", content = listOf()),
            Section( name = "Trending Episodes", order = 2, type= "2_lines_grid", contentType = "episode", content = listOf()),
            Section( name = "Bestselling Audiobooks", order = 3, type= "big_square", contentType = "audio_book", content = listOf()),
        )
        `when`(mockApiService.getHomeSectionsApi()).thenReturn(HomeSectionsResponse(sections = unsortedSections))

        // 2. Act: Call the method being tested.
        val actualSections = homeRepository.getHomeSections()

        // 3. Assert: Verify the result is as expected.
        assertEquals(expectedSortedSections, actualSections)
    }
}