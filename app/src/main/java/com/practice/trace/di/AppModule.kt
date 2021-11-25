package com.practice.trace.di

import android.app.Application
import androidx.room.Room
import com.practice.trace.feature_trace.data.data_source.MoneyDatabase
import com.practice.trace.feature_trace.data.repository.MoneyRepositoryImpl
import com.practice.trace.feature_trace.domain.repository.MoneyRepository
import com.practice.trace.feature_trace.domain.use_case.AddMoney
import com.practice.trace.feature_trace.domain.use_case.DeleteMoney
import com.practice.trace.feature_trace.domain.use_case.GetMoney
import com.practice.trace.feature_trace.domain.use_case.MoneyUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object AppModule {

    @Provides
    @Singleton
    fun provideMoneyDatabase(app: Application): MoneyDatabase{
        return Room.databaseBuilder(
            app,
            MoneyDatabase::class.java,
            MoneyDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideMoneyRepository(db: MoneyDatabase): MoneyRepository {
        return MoneyRepositoryImpl(db.moneyDao)
    }

    @Provides
    @Singleton
    fun provideMoneyUseCases(repository: MoneyRepository): MoneyUseCases{
        return MoneyUseCases(
            getMoney = GetMoney(repository),
            deleteMoney = DeleteMoney(repository),
            addMoney = AddMoney(repository)
        )
    }
}