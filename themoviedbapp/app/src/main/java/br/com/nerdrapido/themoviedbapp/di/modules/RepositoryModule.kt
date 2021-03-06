package br.com.nerdrapido.themoviedbapp.di.modules

import br.com.nerdrapido.themoviedbapp.data.repository.account.AccountRepository
import br.com.nerdrapido.themoviedbapp.data.repository.account.AccountRepositoryImpl
import br.com.nerdrapido.themoviedbapp.data.repository.discover.DiscoverRepository
import br.com.nerdrapido.themoviedbapp.data.repository.discover.DiscoverRepositoryImpl
import br.com.nerdrapido.themoviedbapp.data.repository.login.LoginRepository
import br.com.nerdrapido.themoviedbapp.data.repository.login.LoginRepositoryImpl
import br.com.nerdrapido.themoviedbapp.data.repository.movies.MoviesRepository
import br.com.nerdrapido.themoviedbapp.data.repository.movies.MoviesRepositoryImpl
import br.com.nerdrapido.themoviedbapp.data.repository.session.SessionRepository
import br.com.nerdrapido.themoviedbapp.data.repository.session.SessionRepositoryImpl
import org.koin.dsl.module

/**
 * Created By FELIPE GUSBERTI @ 08/03/2020
 */
class RepositoryModule {

    companion object {

        fun getRepositoryModule() = module {

            single<LoginRepository> { LoginRepositoryImpl(get()) }
            single<SessionRepository> { SessionRepositoryImpl(get()) }
            single<DiscoverRepository> { DiscoverRepositoryImpl(get()) }
            single<MoviesRepository> { MoviesRepositoryImpl(get(), get(), get()) }
            single<AccountRepository> { AccountRepositoryImpl(get(), get()) }

        }
    }
}