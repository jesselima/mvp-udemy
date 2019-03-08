package com.example.mvpudemy.movies;


/**
 * IMAGE SIZES:
 * "backdrop_sizes":    [ "w300", "w780", "w1280", "original" ]
 * "logo_sizes":        [ "w45", "w92", "w154", "w185", "w300", "w500", "original" ]
 * "poster_sizes":      [ "w92", "w154", "w185", "w342", "w500", "w780", "original" ]
 * <p>
 * SAMPLES:
 * <p>
 * "logo_path" /7WsyChQLEftFiDOVTGkv3hFpyyt.jpg
 * SAMPLE IMAGE URL: http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg
 * <p>
 * "poster_path" /7WsyChQLEftFiDOVTGkv3hFpyyt.jpg
 * SAMPLE IMAGE URL: http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg
 * <p>
 * "backdrop_path" /lmZFxXgJE3vgrciwuDib0N8CfQo.jpg
 * SAMPLE IMAGE URL: http://image.tmdb.org/t/p/w185/lmZFxXgJE3vgrciwuDib0N8CfQo.jpg
 */
@SuppressWarnings("ALL")
public final class ApiConfig {

    // API change_keys  constants values. According to api documentation.
    public static final String CHANGE_KEYS_ADULT                = "adult";
    public static final String CHANGE_KEYS_AIR_DATE             = "air_date";
    public static final String CHANGE_KEYS_ALSO_KNOW_AS         = "also_known_as";
    public static final String CHANGE_KEYS_ALTERNATIVE_TITLES   = "alternative_titles";
    public static final String CHANGE_KEYS_BIOGRAPHY            = "biography";
    public static final String CHANGE_KEYS_BIRTHDAY             = "birthday";
    public static final String CHANGE_KEYS_BUDGET               = "budget";
    public static final String CHANGE_KEYS_CAST                 = "cast";
    public static final String CHANGE_KEYS_CERTIFICATIONS       = "certifications";
    public static final String CHANGE_KEYS_CHARACTER_NAMES      = "character_names";
    public static final String CHANGE_KEYS_CREATED_BY           = "created_by";
    public static final String CHANGE_KEYS_CREW                 = "crew";
    public static final String CHANGE_KEYS_DEATH_DAY            = "deathday";
    public static final String CHANGE_KEYS_EPISODE              = "episode";
    public static final String CHANGE_KEYS_EPISODE_NUMBER       = "episode_number";
    public static final String CHANGE_KEYS_EPSIODE_RUN_TIME     = "episode_run_time";
    public static final String CHANGE_KEYS_FREEBASE_ID          = "freebase_id";
    public static final String CHANGE_KEYS_FREEBASE_MID         = "freebase_mid";
    public static final String CHANGE_KEYS_GENERAL              = "general";
    public static final String CHANGE_KEYS_GENRES               = "genres";
    public static final String CHANGE_KEYS_GUEST_STARS          = "guest_stars";
    public static final String CHANGE_KEYS_HOMEPAGE             = "homepage";
    public static final String CHANGE_KEYS_IMAGES               = "images";
    public static final String CHANGE_KEYS_IMDB_ID              = "imdb_id";
    public static final String CHANGE_KEYS_LANGUAGES            = "languages";
    public static final String CHANGE_KEYS_NAME                 = "name";
    public static final String CHANGE_KEYS_NETWORK              = "network";
    public static final String CHANGE_KEYS_ORIGIN_COUNTRY       = "origin_country";
    public static final String CHANGE_KEYS_ORIGINAL_NAME        = "original_name";
    public static final String CHANGE_KEYS_ORIGINAL_TITLE       = "original_title";
    public static final String CHANGE_KEYS_OVERVIEW             = "overview";
    public static final String CHANGE_KEYS_PARTS                = "parts";
    public static final String CHANGE_KEYS_PLACE_OF_BIRTH       = "place_of_birth";
    public static final String CHANGE_KEYS_PLOT_KEYWORDS        = "plot_keywords";
    public static final String CHANGE_KEYS_PRODUCTION_CODE      = "production_code";
    public static final String CHANGE_KEYS_PRODUCTION_COMPANIES = "production_companies";
    public static final String CHANGE_KEYS_PRODUCTION_COUNTRIES = "production_countries";
    public static final String CHANGE_KEYS_RELEASES             = "releases";
    public static final String CHANGE_KEYS_REVENUE              = "revenue";
    public static final String CHANGE_KEYS_RUNTIME              = "runtime";
    public static final String CHANGE_KEYS_SEASON               = "season";
    public static final String CHANGE_KEYS_SEASON_NUMBER        = "season_number";
    public static final String CHANGE_KEYS_SEASON_REGULAR       = "season_regular";
    public static final String CHANGE_KEYS_SPOKEN_LANGUAGES     = "spoken_languages;";
    public static final String CHANGE_KEYS_STATUS               = "status";
    public static final String CHANGE_KEYS_TAGLINE              = "tagline";
    public static final String CHANGE_KEYS_TITLE                = "title";
    public static final String CHANGE_KEYS_TRANSLATIONS         = "translations";
    public static final String CHANGE_KEYS_TVDB_ID              = "tvdb_id";
    public static final String CHANGE_KEYS_TVRAGE_ID            = "tvrage_id;";
    public static final String CHANGE_KEYS_TYPE                 = "type";
    public static final String CHANGE_KEYS_VIDEO                = "video";
    public static final String CHANGE_KEYS_VIDEOS               = "videos";
    // Available language codes according to API documentation follows the ISO_639_1 specification
    public static final String[] LANGUAGES = { "aa","ab","ae","af","ak","am","an","ar","as","av",
            "ay","az","ba","be","bg","bi","bm","bn","bo","br","bs","ca","ce","ch","cn","co","cr",
            "cs","cu","cv","cy","da","de","dv","dz","ee","el","en","eo","es","et","eu","fa","ff",
            "fi","fj","fo","fr","fy","ga","gd","gl","gn","gu","gv","ha","he","hi","ho","hr","ht",
            "hu","hy","hz","ia","id","ie","ig","ii","ik","io","is","it","iu","ja","jv","ka","kg",
            "ki","kj","kk","kl","km","kn","ko","kr","ks","ku","kv","kw","ky","la","lb","lg","li",
            "ln","lo","lt","lu","lv","mg","mh","mi","mk","ml","mn","mo","mr","ms","mt","my","na",
            "nb","nd","ne","ng","nl","nn","no","nr","nv","ny","oc","oj","om","or","os","pa","pi",
            "pl","ps","pt","qu","rm","rn","ro","ru","rw","sa","sc","sd","se","sg","sh","si","sk",
            "sl","sm","sn","so","sq","sr","ss","st","su","sv","sw","ta","te","tg","th","ti","tk",
            "tl","tn","to","tr","ts","tt","tw","ty","ug","uk","ur","uz","ve","vi","vo","wa","wo",
            "xh","xx","yi","za","zh","zu"
    };
    // COMMON USED SIZES TO AVOID REPEATED STRINGS IMAGE SIZE URL PARAMETERS DECLARATION WITH THE SAME VALUE
    private static final String W45     = "w45";
    private static final String W92     = "w92";
    private static final String W154    = "w154";
    private static final String W185    = "w185";
    private static final String W300    = "w300";
    private static final String W342    = "w342";
    private static final String W500    = "w500";
    private static final String H632    = "h632";
    private static final String W780    = "w780";
    private static final String W1280   = "w1280";
    private static final String ORIGINAL = "original";

    private static final String BASE_URL                = "https://api.themoviedb.org/3/";
    private static final String BASE_URL_V3_DISCOVER    = "https://api.themoviedb.org/3/discover/movie";
    private static final String BASE_URL_V3_DEFAULT     = "https://api.themoviedb.org/3/movie/";
    private static final String BASE_IMAGE_URL          = "http://image.tmdb.org/t/p/";
    private static final String SECURE_BASE_IMAGE_URL   = "https://image.tmdb.org/t/p/";
    private static final String BASE_MOVIE_DETAILS_URL  = "https://api.themoviedb.org/3/movie/";
    private static final String BASE_VIDEO_URL_YOUTUBE  = "https://www.youtube.com/watch?v=";
    private static final String BASE_URL_SEARCH         = "https://api.themoviedb.org/3/search/movie";

    public static String getBaseApiUrl() {
        return BASE_URL;
    }

    public static String getBaseMovieApiUrlDiscover() {
        return BASE_URL_V3_DISCOVER;
    }

    public static String getMovieBaseImageUrl() {
        return BASE_IMAGE_URL;
    }

    public static String getSecureBaseImageUrl() {
        return SECURE_BASE_IMAGE_URL;
    }

    public static String getBaseMovieDetailsUrl() {
        return BASE_MOVIE_DETAILS_URL;
    }

    public static String getBaseUrlV3Default() {
        return BASE_URL_V3_DEFAULT;
    }

    public static String getBaseVideoUrlYoutube() {
        return BASE_VIDEO_URL_YOUTUBE;
    }

    public static String getBaseUrlSearch() {
        return BASE_URL_SEARCH;
    }

    /* URL CONSTANT PARAMS KEYS */
    @SuppressWarnings("unused")
    public static final class UrlParamKey {

        public static final String API_KEY          = "api_key";
        public static final String LANGUAGE         = "language";
        public static final String SORT_BY          = "sort_by";
        public static final String INCLUDE_ADULT    = "include_adult";
        public static final String PAGE             = "page";
        public static final String WITH_GENRES      = "with_genres";
        public static final String YEAR             = "year";
        public static final String QUERY            = "query";

        // API backdrop_sizes constants
        public static final String IMAGE_BACKDROP_W300      = W45;
        public static final String IMAGE_BACKDROP_W780      = W780;
        public static final String IMAGE_BACKDROP_W1280     = W1280;
        public static final String IMAGE_BACKDROP_ORIGINAL  = ORIGINAL;
        // API images logo_sizes constants values.
        public static final String IMAGE_LOGO_W45       = W45;
        public static final String IMAGE_LOGO_W92       = W92;
        public static final String IMAGE_LOGO_W154      = W154;
        public static final String IMAGE_LOGO_W185      = W185;
        public static final String IMAGE_LOGO_W300      = W300;
        public static final String IMAGE_LOGO_ORIGINAL  = ORIGINAL;
        // API poster_sizes constants values.
        public static final String IMAGE_POSTER_W92     = W92;
        public static final String IMAGE_POSTER_W154    = W154;
        public static final String IMAGE_POSTER_W185    = W185;
        public static final String IMAGE_POSTER_W342    = W342;
        public static final String IMAGE_POSTER_W500    = W500;
        public static final String IMAGE_POSTER_W780    = W780;
        public static final String IMAGE_POSTER_ORIGINAL = ORIGINAL;
        // API images profile_sizes constants values.
        public static final String IMAGE_PROFILE_W45    = W92;
        public static final String IMAGE_PROFILE_W185   = W185;
        public static final String IMAGE_PROFILE_H632   = H632;
        public static final String IMAGE_PROFILE_ORIGINAL = ORIGINAL;
        // API images still_sizes constants values.
        public static final String IMAGE_STILL_W92      = W92;
        public static final String IMAGE_STILL_W185     = W185;
        public static final String IMAGE_STILL_W300     = W300;
        public static final String IMAGE_STILL_ORIGINAL = ORIGINAL;

        public static final int VIDEO_SIZE = 360;

    }

    public static final class UrlParamValue {
        /* URL PARAMETERS VALUES  */
        public static final String POPULARITY_DESC          = "popularity.desc";
        public static final String POPULARITY_ASC           = "popularity.asc";
        public static final String RELEASE_DATE_ASC_        = "release_date.asc";
        public static final String RELEASE_DATE_DESC_       = "release_date.desc";
        public static final String REVENUE_ASC_             = "revenue.asc";
        public static final String REVENUE_DESC_            = "revenue.desc";
        public static final String PRIMARY_RELEASE_DATE_ASC = "primary_release_date.asc";
        public static final String PRIMARY_RELEASE_DATE_DESC = "primary_release_date.desc";
        public static final String ORIGINAL_TITLE_ASC       = "original_title.asc";
        public static final String ORIGINAL_TITLE_DESC      = "original_title.desc";
        public static final String VOTE_AVERAGE_ASC_        = "vote_average.asc";
        public static final String VOTE_AVERAGE_DESC        = "vote_average.desc";
        public static final String VOTE_COUNT_ASC_          = "vote_count.asc";
        public static final String VOTE_COUNT_DESC          = "vote_count.desc";
        public static final String INCLUDE_ADULT_TRUE       = "true";
        public static final String INCLUDE_ADULT_FALSE      = "false";
        public static final String LANGUAGE_DEFAULT         = "en";
        public static final String POPULAR                  = "popular";
        public static final String TOP_RATED                = "top_rated";

    }

    public static final class JsonKey {

        public static final String RESULTS          = "results";
        public static final String VOTE_COUNT       = "vote_count";
        public static final String ID               = "id";
        public static final String VIDEO            = "video";
        public static final String VOTE_AVERAGE     = "vote_average";
        public static final String TITLE            = "title";
        public static final String POPULARITY       = "popularity";
        public static final String POSTER_PATH      = "poster_path";
        public static final String ORIGINAL_LANGUAGE = "original_language";
        public static final String ORIGINAL_TITLE   = "original_title";
        public static final String GENRE_IDS        = "genre_ids"; // Array of int
        public static final String GENRES           = "genres"; // Array of int
        public static final String BACKDROP_PATH    = "backdrop_path";
        public static final String ADULT            = "adult";
        public static final String OVERVIEW         = "overview";
        public static final String RELEASE_DATE     = "release_date";
        public static final String TAGLINE          = "tagline";
        public static final String MDB_ID           = "imdb_id";
        public static final String BUDGET           = "budget";
        public static final String REVENUE          = "revenue";
        public static final String RUNTIME          = "runtime";
        public static final String SPOKEN_LANGUAGES = "spoken_languages";
        public static final String NAME             = "name";
        public static final String HOMEPAGE         = "homepage";
        public static final String PRODUCTION_COMPANIES = "production_companies";
        public static final String LOGO_PATH        = "logo_path";
        public static final String ORIGIN_COUNTRY   = "origin_country";

    }

}

