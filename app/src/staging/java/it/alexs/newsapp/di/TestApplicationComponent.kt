package it.alexs.newsapp.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FakeNetworkModule::class])
interface TestApplicationComponent: ApplicationComponent {
}