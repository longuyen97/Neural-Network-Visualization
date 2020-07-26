package de.longuyen.trainer

import de.longuyen.data.DataEncoder
import de.longuyen.data.DataGenerator
import de.longuyen.data.HousePriceDataEncoder
import de.longuyen.data.HousePriceDataGenerator
import org.nd4j.linalg.api.ndarray.INDArray

class HousePriceModelTrainer {
    private val dataGenerator: DataGenerator = HousePriceDataGenerator()
    private val dataEncoder: DataEncoder

    init {
        dataEncoder = HousePriceDataEncoder(dataGenerator.getTrainingData())
    }
    fun train() {
        val dataGenerator = HousePriceDataGenerator()
        val trainingData = dataGenerator.getTrainingData()
        val testingData = dataGenerator.getTestingData()

        val dataEncoder = HousePriceDataEncoder(trainingData)


    }

    fun getTrainingData() : Pair<INDArray, INDArray>{
        return dataEncoder.encode()
    }

    fun getTestingData() : INDArray {
        return dataEncoder.encodeFutureData(dataGenerator.getTestingData())
    }

    fun getValidatingData() : INDArray {
        return dataEncoder.encodeFutureData(dataGenerator.getValidatingData())
    }
}