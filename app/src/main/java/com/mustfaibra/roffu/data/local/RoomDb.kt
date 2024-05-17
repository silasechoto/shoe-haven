package com.mustfaibra.roffu.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mustfaibra.roffu.R
import com.mustfaibra.roffu.models.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [
        Advertisement::class,
        Manufacturer::class,
        Review::class,
        User::class,
        PaymentProvider::class,
        UserPaymentProvider::class,
        Product::class,
        BookmarkItem::class,
        Location::class,
        CartItem::class,
        Order::class,
        OrderItem::class,
        OrderPayment::class,
        Notification::class,
        ProductColor::class,
        ProductSize::class,
    ],
    version = 1, exportSchema = false)
abstract class RoomDb : RoomDatabase() {

    /** A function that used to retrieve Room's related dao instance */
    abstract fun getDao(): RoomDao

    class PopulateDataClass @Inject constructor(
        private val client: Provider<RoomDb>,
        private val scope: CoroutineScope,
    ) : RoomDatabase.Callback() {
        private val description =
            "This is the description text that is supposed to be long enough to show how the UI looks, so it's not a real text.\n"
        private val manufacturers = listOf(
            Manufacturer(id = 1, name = "Nike", icon = R.drawable.ic_nike),
            Manufacturer(id = 2, name = "Adidas", icon = R.drawable.adidas_48),
            Manufacturer(id = 91, name = "Leather", icon = R.drawable.clarksblak),
            Manufacturer(id = 90, name = "Jordan", icon = R.drawable.jordanlogo),



        )
        private val advertisements = listOf(
            Advertisement(1, R.drawable.ic_nike, 1, 0),
            Advertisement(2, R.drawable.adidaslogo, 2, 0),
            Advertisement(3, R.drawable.leather, 3, 0),
            Advertisement(4, R.drawable.jordi, 4, 0),
            Advertisement(5, R.drawable.converselogo, 5, 0),
            Advertisement(6, R.drawable.sneakerslogo, 6, 0)
        )
        private val nikeProducts = listOf(
            Product(
                id = 1,
                name = "Pegasus Trail Gortex Green",
                image = R.drawable.pegasus_trail_3_gore_tex_dark_green,
                price = 999.0,
                description = description,
                manufacturerId = 1,
                basicColorName = "dark-green",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(
                        productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image
                    ),
                    ProductColor(
                        productId = it.id,
                        colorName = "lemon",
                        image = R.drawable.pegasus_trail_3_gore_tex_lemon
                    ),
                )
            },
            Product(
                id = 3,
                name = "Air Huarache Gold",
                image = R.drawable.air_huarache_le_gold_black,
                price = 1450.0,
                description = description,
                manufacturerId = 1,
                basicColorName = "gold",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(
                        productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image
                    ),
                    ProductColor(
                        productId = it.id,
                        colorName = "gray",
                        image = R.drawable.air_huarache_le_gray_dark
                    ),
                    ProductColor(
                        productId = it.id,
                        colorName = "pink",
                        image = R.drawable.air_huarache_le_pink_black
                    ),
                    ProductColor(
                        productId = it.id,
                        colorName = "red",
                        image = R.drawable.air_huarache_le_red_black
                    ),
                )


            },


            Product(
                id = 7,
                name = "Blazer Low Black",
                image = R.drawable.blazer_low_black,
                price = 990.0,
                description = description,
                manufacturerId = 1,
                basicColorName = "black",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(
                        productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image
                    ),
                    ProductColor(
                        productId = it.id,
                        colorName = "pink",
                        image = R.drawable.blazer_low_pink
                    ),
                    ProductColor(
                        productId = it.id,
                        colorName = "lemon",
                        image = R.drawable.blazer_low_light_green
                    ),
                )
            },




        Product(
        id = 95,
        name = "Airforce [AF1]",
        image = R.drawable.airforce1black,
        price = 999.0,
        description = description,
        manufacturerId = 1,
        basicColorName = "black",
        ).also {
            it.colors = mutableListOf(
                ProductColor(productId = 95,
                    colorName = it.basicColorName,
                    image = it.image),
                ProductColor(productId = 95,
                    colorName = "white",
                    image = R.drawable.airforce1white),
                ProductColor(productId = 95,
                    colorName = "blue",
                    image = R.drawable.airforce1blue),
                ProductColor(productId = 95,
                    colorName = "green",
                    image = R.drawable.airforce1green),



                    )
               },


            Product(
                id = 96,
                name = "Nike Revolution 7",
                image = R.drawable.nikeshoeblack,
                price = 879.0,
                description = description,
                manufacturerId = 1,
                basicColorName = "black",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = 96,
                        colorName = it.basicColorName,
                        image = it.image),
                    ProductColor(productId = 96,
                        colorName = "white",
                        image = R.drawable.nikeshoewhite),
                    ProductColor(productId = 96,
                        colorName = "blue",
                        image = R.drawable.nikeshoeblue),
                    ProductColor(productId = 96,
                        colorName = "orange",
                        image = R.drawable.nikeshoeorange),



                    )
            },


            Product(
                id = 3,
                name = "Air Huarache Gold",
                image = R.drawable.air_huarache_le_gold_black,
                price = 1450.0,
                description = description,
                manufacturerId = 1,
                basicColorName = "gold",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(
                        productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image
                    ),
                    ProductColor(
                        productId = it.id,
                        colorName = "gray",
                        image = R.drawable.air_huarache_le_gray_dark
                    ),
                    ProductColor(
                        productId = it.id,
                        colorName = "pink",
                        image = R.drawable.air_huarache_le_pink_black
                    ),
                    ProductColor(
                        productId = it.id,
                        colorName = "red",
                        image = R.drawable.air_huarache_le_red_black
                    ),
                )

            },
            Product(
                id = 7,
                name = "Blazer Low Black",
                image = R.drawable.blazer_low_black,
                price = 990.0,
                description = description,
                manufacturerId = 1,
                basicColorName = "black",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                    ProductColor(productId = it.id,
                        colorName = "pink",
                        image = R.drawable.blazer_low_pink),
                    ProductColor(productId = it.id,
                        colorName = "lemon",
                        image = R.drawable.blazer_low_light_green),
                      )
                   },
              )

        private val leatherproducts = listOf(
            Product(
                id = 91,
                name = "Wallabies",
                image = R.drawable.clarksblak,
                price = 890.0,
                description = description,
                manufacturerId = 91,
                basicColorName = "black",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = 91,
                        colorName = it.basicColorName,
                        image = it.image),
                    ProductColor(productId = 91,
                        colorName = "brown",
                        image = R.drawable.clarksbrown),
                    ProductColor(productId = 91,
                        colorName = "purple",
                        image = R.drawable.clarkspurple),
                    )
                  },


                Product(
                    id = 39,
                    name = "Louvre Genuine Leather Loafer Shoes",
                    image = R.drawable.louverskibla,
                    price = 1099.0,
                    description = description,
                    manufacturerId = 91,
                    basicColorName = "black",
                ).also {
                    it.colors = mutableListOf(
                        ProductColor(productId = 39,
                            colorName = it.basicColorName,
                            image = it.image),
                        ProductColor(productId = 39,
                            colorName = "brown",
                            image = R.drawable.louversbrown),

                    )
                },
            )



        private val jordanproducts = listOf(
            Product(
                id = 90,
                name = "Jordan 4",
                image = R.drawable.j4black,
                price = 3900.0,
                description = description,
                manufacturerId = 90,
                basicColorName = "black",
            ).also {
                val black = ""
                it.colors = mutableListOf(
                    ProductColor(productId = 90,
                        colorName = black,
                        image = R.drawable.j4black),
                    ProductColor(productId = 90,
                        colorName = "red",
                        image = R.drawable.j4red),
                    ProductColor(productId = 90,
                        colorName = "blue",
                        image = R.drawable.j4blue),
                    ProductColor(productId = 90,
                        colorName = "white",
                        image = R.drawable.j4white),
                    ProductColor(productId = 90,
                        colorName = "orange",
                        image = R.drawable.j4orange),

                )
                   },
        )



        private val adidasProducts = listOf(
            Product(
                id = 10,
                name = "Defiant Generation Green",
                image = R.drawable.defiant_generation_green,
                price = 999.0,
                description = description,
                manufacturerId = 2,
                basicColorName = "green",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                    ProductColor(productId = it.id,
                        colorName = "red",
                        image = R.drawable.defiant_generation_red),
                )
            },

            Product(
                id = 12,
                name = "Solarthon Primegreen Gray",
                image = R.drawable.solarthon_primegreen_gray,
                price = 990.0,
                description = description,
                manufacturerId = 2,
                basicColorName = "gray",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                    ProductColor(productId = it.id,
                        colorName = "black",
                        image = R.drawable.solarthon_primegreen_black),
                    ProductColor(productId = it.id,
                        colorName = "red",
                        image = R.drawable.solarthon_primegreen_red),
                )
            },


            Product(
                id = 17,
                name = "Adidas Superstar",
                image = R.drawable.adidasshoeblack,
                price = 999.0,
                description = description,
                manufacturerId = 2,
                basicColorName = "black",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                    ProductColor(productId = it.id,
                        colorName = "red",
                        image = R.drawable.adidasshoered),
                    ProductColor(productId = it.id,
                        colorName = "blue",
                        image = R.drawable.adidasshoeblue),
                    ProductColor(productId = it.id,
                        colorName = "green",
                        image = R.drawable.adidasshoegreen),
                    ProductColor(productId = it.id,
                        colorName = "white",
                        image = R.drawable.adidasshoewhite),

                )
              },

            Product(
                id = 18,
                name = "Fear of God Adidas Forum 86",
                image = R.drawable.fogadidasblack,
                price = 999.0,
                description = description,
                manufacturerId = 2,
                basicColorName = "black",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                    ProductColor(productId = it.id,
                        colorName = "white",
                        image = R.drawable.fogadidaswhite),
                )
              },
            )


        









        private val paymentProviders = listOf(
            PaymentProvider(
                id = "apple",
                title = R.string.apple_pay,
                icon = R.drawable.ic_apple,
            ),
            PaymentProvider(
                id = "master",
                title = R.string.master_card,
                icon = R.drawable.ic_master_card,
            ),
            PaymentProvider(
                id = "visa",
                title = R.string.visa,
                icon = R.drawable.ic_visa,
            ),
        )
        private val userPaymentAccounts = listOf(
            UserPaymentProvider(
                providerId = "apple",
                cardNumber = "8402-5739-2039-5780"
            ),
            UserPaymentProvider(
                providerId = "master",
                cardNumber = "3323-8202-4748-2002"
            ),
            UserPaymentProvider(
                providerId = "visa",
                cardNumber = "7483-02836-4839-2855"
            ),
        )
        private val userLocation = Location(
            address = "P.O. BOX 15, CBD, MOI AVENUE",
            city = "Nairobi",
            country = "Kenya",
        )

        init {
            nikeProducts.onEach {
                it.sizes = mutableListOf(
                    ProductSize(it.id, 38),
                    ProductSize(it.id, 40),
                    ProductSize(it.id, 42),
                    ProductSize(it.id, 44),
                )
            }
            adidasProducts.onEach {
                it.sizes = mutableListOf(
                    ProductSize(it.id, 38),
                    ProductSize(it.id, 40),
                    ProductSize(it.id, 42),
                    ProductSize(it.id, 44),
                )
            }
























            leatherproducts.onEach {
                it.sizes = mutableListOf(
                    ProductSize(it.id, 38),
                    ProductSize(it.id, 40),
                    ProductSize(it.id, 42),
                    ProductSize(it.id, 44),
                )
            }
            val onEach = jordanproducts.onEach {
                it.sizes= mutableListOf(
                    ProductSize(it.id, 38),
                    ProductSize(it.id, 40),
                    ProductSize(it.id, 42),
                    ProductSize(it.id, 44),
                )


                    scope.launch {
                        populateDatabase(dao = client.get().getDao(), scope = scope)
                    }
            }
        }









        private suspend fun populateDatabase(dao: RoomDao, scope: CoroutineScope) {
            /** Save users */
            scope.launch {
                dao.saveUser(
                    User(
                        userId = 1,
                        name = "Silas Echoto",
                        profile = R.drawable.shoehaven,
                        phone = "0741097262",
                        email = "echotosilas@gmail.com",
                        password = "qwertyuiop",
                        token = "ds2f434ls2ks2lsj2ls",
                    )
                )
            }
            /** insert manufacturers */
            scope.launch {
                manufacturers.forEach {
                    dao.insertManufacturer(it)
                }
            }
            /** insert advertisements */
            scope.launch {
                advertisements.forEach {
                    dao.insertAdvertisement(it)
                }
            }
            /** Insert products */
            scope.launch {
                nikeProducts.plus(adidasProducts).plus(leatherproducts).plus(jordanproducts).forEach {
                    /** Insert the product itself */
                    dao.insertProduct(product = it)
                    /** Insert colors */
                    it.colors?.forEach { productColor ->
                        dao.insertOtherProductCopy(productColor)
                    }
                    /** Insert size */
                    it.sizes?.forEach { productSize ->
                        dao.insertSize(productSize)
                    }
                }
            }

















            /** Insert payment providers */
            scope.launch {
                paymentProviders.forEach {
                    dao.savePaymentProvider(paymentProvider = it)
                }
            }
            /** Insert user's payment providers */
            scope.launch {
                userPaymentAccounts.forEach {
                    dao.saveUserPaymentProvider(it)
                }
            }
            /** Insert user's location */
            scope.launch {
                dao.saveLocation(location = userLocation)
            }
        }
    }

  }
