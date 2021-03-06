package br.com.nerdrapido.themoviedbapp.ui.abstracts

/**
 * Created By FELIPE GUSBERTI @ 08/03/2020
 */
interface View {

    /**
     * Routes the user back to login
     */
    fun goBackToLogin()

    fun goHome()

    fun showLoading()

    fun dismissLoading()

    fun showNetworkError()

    fun showApiErrorResponse()

    fun showUnknownError()

}