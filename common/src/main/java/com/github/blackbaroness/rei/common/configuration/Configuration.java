package com.github.blackbaroness.rei.common.configuration;

import space.arim.dazzleconf.annote.ConfComments;
import space.arim.dazzleconf.annote.ConfDefault.*;
import space.arim.dazzleconf.annote.IntegerRange;
import space.arim.dazzleconf.annote.SubSection;

import java.util.Collection;

public interface Configuration {

    @ConfComments("The repository where player data will be stored. Most often a database.")
    @SubSection
    Repository repository();

    interface Repository {

        @ConfComments({
            "Important feature. Look, the point is that if your repository suddenly becomes unavailable DURING STARTUP,",
            "the plugin simply won't work correctly. To avoid the total destruction of your server, we can disable the server.",
            "It is recommended to use this in conjunction with some kind of reboot system,",
            "then perhaps repeated attempts will lead to success."
        })
        @DefaultBoolean(true)
        boolean shutdownServerOnConnectionFailure();

        @ConfComments("Type of repository: H2, MYSQL, MARIADB or POSTGRESQL.")
        @DefaultString("H2")
        Type type();

        @ConfComments({
            "A cache is a thing that keeps a certain amount of data from a database in RAM.",
            "Thus, sometimes you don`t have to “knock” on the database - we already have everything!",
            "This greatly speeds up many operations."
        })
        @SubSection
        Cache cache();

        @ConfComments("Settings for MySQL. If you selected another repository type, just ignore that.")
        @SubSection
        SqlDatabase mysql();

        @ConfComments("Settings for MariaDB. If you selected another repository type, just ignore that.")
        @SubSection
        SqlDatabase mariadb();

        @ConfComments("Settings for PostgreSQL. If you selected another repository type, just ignore that.")
        @SubSection
        SqlDatabase postgresql();

        enum Type {
            H2,
            MYSQL,
            MARIADB,
            POSTGRESQL
        }

        interface Cache {

            @ConfComments("Do you want to use cache?")
            @DefaultBoolean(true)
            boolean enabled();

            @ConfComments({
                "The maximum cache size. If the cache gets full, the oldest entries will be deleted.",
                "Too large size will cause the cache access to take longer than expected."
            })
            @IntegerRange(min = 0)
            @DefaultInteger(10000)
            long maxSize();

            @ConfComments({
                "Old (unused) cache can be cleaned up to make things faster and your RAM happier.",
                "Here you can set after what period of time old cache will be cleaned.",
                "If you don't want to clean up the old cache, set this to 0."
            })
            @DefaultLong(1200)
            long expireAfterSeconds();
        }

        interface SqlDatabase {

            @ConfComments("Address of the database.")
            @DefaultString("localhost")
            String address();

            @ConfComments("Port of the database. Just left 0 if you want to use the default one.")
            @IntegerRange(max = 65535)
            @DefaultInteger(0)
            int port();

            @ConfComments("Database name")
            @DefaultString("my-awesome-database")
            String databaseName();

            @ConfComments("Password to access the database.")
            @DefaultString("root")
            String user();

            @ConfComments("Password to access the database. Left untouched if your database doesn't require a password.")
            @DefaultString("your_password")
            String password();

            @ConfComments("Extra arguments to connection url. Left untouched if you don't know what is that.")
            @DefaultStrings("autoReconnect=true")
            Collection<String> arguments();
        }


    }
}
