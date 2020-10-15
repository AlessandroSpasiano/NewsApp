package it.alexs.newsapp.di

import dagger.Component
import it.alexs.newsappmvvm_library.scope.AppScope

@AppScope
@Component
interface TestApplicationComponent: ApplicationComponent {
}