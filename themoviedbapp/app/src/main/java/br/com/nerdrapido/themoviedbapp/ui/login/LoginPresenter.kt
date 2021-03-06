package br.com.nerdrapido.themoviedbapp.ui.login

import br.com.nerdrapido.themoviedbapp.data.model.login.RequestTokenResponse
import br.com.nerdrapido.themoviedbapp.ui.abstracts.Presenter

/**
 * Created By FELIPE GUSBERTI @ 08/03/2020
 */
interface LoginPresenter : Presenter<LoginView> {

    /**
     * Called when the user start a login attempt.
     */
    fun loginWasCalled()

    fun loginSuccess(requestTokenResponse: RequestTokenResponse)

    fun loginDenied()
}