package com.indigo.graphql.di

import com.apollographql.apollo3.ApolloClient
import com.indigo.graphql.network.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class GraphQlModule {

    @Provides
    @Singleton
    fun provideBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun provideApolloClient(baseUrl: String): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(baseUrl)
            .build()
    }






}
