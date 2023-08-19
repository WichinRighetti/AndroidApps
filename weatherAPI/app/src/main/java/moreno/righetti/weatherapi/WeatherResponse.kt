package moreno.righetti.weatherapi

data class WeatherResponse(
    val main: Main,
    val weather: List<Weather>
)

data class Main(
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double,
    val humidity: Int
)

data class Weather(
    val description: String,
    val icon: String
)
