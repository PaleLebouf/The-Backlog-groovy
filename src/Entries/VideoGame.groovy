package Entries

class VideoGame implements EntryItem {

    VideoGame(String CSVString) {
        String[] splitStrings = CSVString.split(',')
        title = splitStrings[0]
        status = (splitStrings[1] as int) as EntryStatus
    }

    VideoGame() {
        update()
    }

    VideoGame(String title, EntryStatus status) {
        this.title = title
        this.status = status
    }

    @Override
    boolean update() {
        print('Please enter a title: ')
        title = System.in.newReader()
        print('\nPlease enter status (0 = not started, 1 = in progress, 2 = finished')
        status = System.in.newReader() as EntryStatus

        true
    }

    String toCSV() {
        title + ',' + (status as int) + '\n'
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
        title + '\t' + stringStatus
    }
}
