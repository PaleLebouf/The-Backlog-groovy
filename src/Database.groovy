import Entries.*
import javafx.scene.chart.XYChart


class Database {
    private static ArrayList<VideoGame> gameList
    private static ArrayList<Series> animeList
    private static ArrayList<Series> westernList
    private static ArrayList<Manga> mangaList
    private static Random random


    Database() {
        random = new Random()
        File gameFile = new File("gameDB.csv")
        File animeFile = new File("animeDB.csv")
        File westernFile = new File("westernDB.csv")
        File mangaFile = new File("mangaDB.csv")
        if (gameFile.exists() && animeFile.exists() && westernFile.exists() && mangaFile.exists()) {
            //read files into lists
            gameFile.withReader { reader ->
                while ((line = reader.readLine()) != null) {
                    gameList << new VideoGame(line)
                }
            }

            animeFile.withReader { reader ->
                while ((line = reader.readLine()) != null) {
                    animeList << new Series(line)
                }
            }

            westernFile.withReader { reader ->
                while ((line = reader.readLine()) != null) {
                    westernList << new Series(line)
                }
            }

            mangaFile.withReader { reader ->
                while ((line = reader.readLine()) != null) {
                    mangaList << new Manga(line)
                }
            }
        } else {
            gameList = []
            animeList = []
            westernList = []
            mangaList = []
        }
    }

    void addEntry(int entryType) {
        if (entryType == 1) {
            gameList << new VideoGame()
        } else if (entryType == 2) {
            animeList << new Series()
        } else if (entryType == 3) {
            mangaList << new Manga()
        } else if (entryType == 4) {
            westernList << new Series()
        } else {
            println('Error, invalid entry type "' + entryType + '"')
        }
    }


    void removeEntry(int entryType, int index) {
        if (entryType == 1 && gameList[index] != null) {
            gameList.remove(index)
        } else if (entryType == 2 && animeList[index] != null) {
            animeList.remove(index)
        } else if (entryType == 3 && mangaList[index] != null) {
            mangaList.remove(index)
        } else if (entryType == 4 && westernList[index] != null) {
            westernList.remove(index)
        } else {
            println('Error, invalid entry type "' + entryType + '" or missing item at index ' + index)
        }
    }

    void view(int entryType) {
        def list = copyArrayList(entryType)

        println('-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-')
        print('Title\tStatus')
        if (entryType == 2 || entryType == 4) {
            print('\tEpisode Progress')
        } else if (entryType == 3) {
            print('\tChapter Progress')
        }
        println()

        list.each { entry ->
            println(entry.toString())
        }

        println()
    }

    void export() {
        File gameFile = new File("gameDB.csv")
        File animeFile = new File("animeDB.csv")
        File westernFile = new File("westernDB.csv")
        File mangaFile = new File("mangaDB.csv")

        gameList.each { game ->
            gameFile << game.toCSV()
        }
        animeList.each { anime ->
            animeFile << anime.toCSV()
        }
        westernList.each { western ->
            westernFile << western.toCSV()
        }
        mangaList.each { manga ->
            mangaFile << manga.toCSV()
        }

    }

    void getRandomEntryToDo() {
        int entryType = random.ints(1, 4)
        def list = copyArrayList(entryType)
        println(entryType)

        int index = random.ints(0, list.size())

        println('Try working on this in your backlog: ')
        println(list[index].toString())

    }

    ArrayList<EntryItem> copyArrayList(int entryType) {
        def list
        if (entryType == 1) {
            list = gameList.clone()
        } else if (entryType == 2) {
            list = animeList.clone()
        } else if (entryType == 3) {
            list = mangaList.clone()
        } else if (entryType == 4) {
            list = westernList.clone()
        }

        list
    }

}
