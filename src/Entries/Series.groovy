package Entries

class Series implements EntryItem {


    int currentEpisode
    int totalEpisodes

    Series(String CSVString) {
        String[] splitStrings = CSVString.split(',')
        title = splitStrings[0]
        status = (splitStrings[1] as int) as EntryStatus
        currentEpisode = splitStrings[2] as int
        totalEpisodes = splitStrings[3] as int
    }

    Series() {
        update()
    }

    Series(String title, EntryStatus status, int currentEp, int totalEps) {
        this.title = title
        this.status = status
        this.currentEpisode = currentEp
        this.totalEpisodes = totalEps
    }

    @Override
    boolean update() {
        print('Please enter a title: ')
        title = System.in.newReader()
        print('\nPlease enter status (0 = not started, 1 = in progress, 2 = finished')
        status = System.in.newReader() as EntryStatus
        print('Please enter current episode: ')
        currentEpisode = System.in.newReader() as int
        print('Please enter total episodes: ')
        totalEpisodes = System.in.newReader() as int
    }

    String toCSV() {
        title + ',' + (status as int) + ',' + currentEpisode + ',' + totalEpisodes + '\n'
    }

    String toString(){
        String stringStatus
        switch(status){
            case EntryStatus.NotStarted:
                stringStatus = 'Not Started'
                break
            case EntryStatus.InProgress:
                stringStatus = 'In Progress'
                break
            case EntryStatus.Finished:
                stringStatus = 'Finished'
        }
        title + '\t' + stringStatus + '\t' + currentEpisode + '/' + totalEpisodes
    }
}
