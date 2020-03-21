package br.com.nerdrapido.themoviedbapp.ui.home

import android.os.Bundle
import br.com.nerdrapido.themoviedbapp.R
import br.com.nerdrapido.themoviedbapp.data.model.common.MovieListResultObject
import br.com.nerdrapido.themoviedbapp.ui.abstracts.navigation.NavigationActivity
import br.com.nerdrapido.themoviedbapp.ui.components.abstracts.MovieListView
import br.com.nerdrapido.themoviedbapp.ui.components.horizontalmovielist.HorizontalMovieListView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import timber.log.Timber


/**
 * Created By FELIPE GUSBERTI @ 10/03/2020
 */
class HomeActivity : NavigationActivity<HomeView, HomePresenter>(), HomeView,
    BottomNavigationView.OnNavigationItemSelectedListener {


    override val presenter: HomePresenter by inject()

    override val nestedActivityLayoutId = R.layout.activity_home

    override fun getActivityTitle(): String {
        return getString(R.string.home_title)
    }

    override fun goHome() {
        Timber.i("Already in home")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Do the list setup
        setupList(
            getString(R.string.em_alta),
            homeListA
        ) { page -> presenter.loadDiscoverPage(page) }
        setupList(
            getString(R.string.filmes_de, getString(R.string.acao)),
            homeListB
        ) { page -> presenter.loadActionPage(page) }
        setupList(
            getString(R.string.filmes_de, getString(R.string.comedia)),
            homeListC
        ) { page -> presenter.loadComedyPage(page) }
        setupList(
            getString(R.string.filmes_de, getString(R.string.ficcao_cientifica)),
            homeListD
        ) { page -> presenter.loadScienceFictionPage(page) }

    }

    override fun onResume() {
        super.onResume()
        showLoading()
    }

    private fun setupList(
        title: String? = null,
        horizontalMovieListView: HorizontalMovieListView,
        loadPage: suspend (page: Int) -> List<MovieListResultObject>
    ) {
        horizontalMovieListView.titleText = title
        horizontalMovieListView.setOnPageChangeListener(
            5,
            20,
            object : MovieListView.OnNextPageNeeded {
                override fun onNextPageNeeded(page: Int) {
                    GlobalScope.launch {
                        val list = loadPage(page)
                        runOnUiThread {
                            horizontalMovieListView.addItemList(list)
                            dismissLoading()
                        }
                    }
                }
            }
        )
    }
}