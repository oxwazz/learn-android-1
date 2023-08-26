package com.example.movieapp.model

data class Movie(
    val id: String,
    val title: String,
    val year: String,
    val genre: String,
    val director: String,
    val actors: String,
    val plot: String,
    val poster: String,
    val images: List<String>,
    val rating: String,
)

fun getMovies(): List<Movie> {
    return listOf(
        Movie(
            id = "1",
            title = "Batman: Year One1",
            year = "1996",
            genre = "Action|Animation|Crime",
            director = "Ken Bartels-Ellis",
            actors = "Mord Hawe",
            plot = "Room 891",
            poster = "https://images4.alphacoders.com/132/1328014.jpg",
            images = listOf(
                "https://images4.alphacoders.com/128/1289068.jpg",
                "https://assetsio.reedpopcdn.com/digitalfoundry-2016-batman-return-to-arkham-face-off-1477586823333.jpg?width=1200&height=630&fit=crop&enable=upscale&auto=webp",
            ),
            rating = "3",
        ),
        Movie(
            id = "2",
            title = "Batman: Year One2",
            year = "1996",
            genre = "Action|Animation|Crime",
            director = "Ken Bartels-Ellis",
            actors = "Mord Hawe",
            plot = "Room 891",
            poster = "https://www.sideshow.com/storage/product-images/908079/batman_dc-comics_square.jpg",
            images = listOf(
                "https://cdn1.epicgames.com/undefined/offer/batman-arkham-asylum_promo-1567x917-f1248a17909e224f91845b223542306a.jpg?h=270&quality=medium&resize=1&w=480",
                "https://assets.nintendo.com/image/upload/c_fill,w_1200/q_auto:best/f_auto/dpr_2.0/ncom/software/switch/70010000068296/30648e0a24cff549fe97f586431b4b927a8e49f3531108ec50fd00a106733b4d",
                "https://cdn.cloudflare.steamstatic.com/steam/subs/320795/header.jpg?t=1636658684",
            ),
            rating = "3",
        ),
        Movie(
            id = "3",
            title = "Batman: Year One3",
            year = "1996",
            genre = "Action|Animation|Crime",
            director = "Ken Bartels-Ellis",
            actors = "Mord Hawe",
            plot = "Room 891",
            poster = "https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/RL6NO4TJEFFN5GGLYYQZCFMTC4.jpg",
            images = listOf(
                "https://o-cdn-cas.sirclocdn.com/parenting/images/batman-film.width-800.format-webp.webp",
                "https://www.comingsoon.net/wp-content/uploads/sites/3/2023/03/batman-doom-gotham-header.png?resize=1200,630",
            ),
            rating = "3",
        ), Movie(
            id = "4",
            title = "Batman: Year One4",
            year = "1996",
            genre = "Action|Animation|Crime",
            director = "Ken Bartels-Ellis",
            actors = "Mord Hawe",
            plot = "Room 891",
            poster = "https://cdn.antaranews.com/cache/1200x800/2021/04/20/batman-keaton.png",
            images = listOf(
                "https://i.kinja-img.com/gawker-media/image/upload/c_fill,f_auto,fl_progressive,g_center,h_675,pg_1,q_80,w_1200/ca225ff72bf6775cd4b1a8855f5540cd.jpg",
                "https://static.dc.com/dc/files/default_images/BM80-KeyMoments_Marq_BM27_5c913a36a257b3.66149289.jpg?w=1200"
            ),
            rating = "3",
        ), Movie(
            id = "5",
            title = "Batman: Year One5",
            year = "1996",
            genre = "Action|Animation|Crime",
            director = "Ken Bartels-Ellis",
            actors = "Mord Hawe",
            plot = "Room 891",
            poster = "https://awsimages.detik.net.id/community/media/visual/2023/06/13/sinopsis-film-batman-robin_43.jpeg?w=1200",
            images = listOf(
                "https://batman-news.com/wp-content/uploads/2022/11/The-Adventures-of-Batman-Blu-ray-Featured-01.jpg",
                "https://images.thedirect.com/media/article_full/superman-batman.jpg",
                "https://assetsio.reedpopcdn.com/Batman-Fortress-8-2-(1).jpg?width=1200&height=1200&fit=bounds&quality=70&format=jpg&auto=webp"
            ),
            rating = "3",
        ),
        Movie(
            id = "6",
            title = "Batman: Year One66",
            year = "1996",
            genre = "Action|Animation|Crime",
            director = "Ken Bartels-Ellis",
            actors = "Mord Hawe",
            plot = "Room 891",
            poster = "https://image.api.playstation.com/vulcan/img/rnd/202010/2621/H9v5o8vP6RKkQtR77LIGrGDE.png",
            images = listOf(
                "https://m.media-amazon.com/images/M/MV5BZDExMWQ5MDQtMWNjNy00M2EzLWE1M2EtYzFhNDVhM2Q5MDI1XkEyXkFqcGdeQXVyNTA4NzExMDg@._V1_FMjpg_UX1000_.jpg"
            ),
            rating = "3",
        )
    )
}

