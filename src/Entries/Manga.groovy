package Entries

class Manga implements EntryItem {

    int currentChapter
    int totalChapters

    Manga(String CSVString) {
        String[] splitStrings = CSVString.split(',')
        title = splitStrings[0]
        status = (splitStrings[1] as int) as EntryStatus
        currentChapter = splitStrings[2] as int
        totalChapters = splitStrings[3] as int
    }

    Manga() {
        update()
    }

    Manga(String title, EntryStatus status, int currentChap, int totalChaps) {
        this.title = title
        this.status = status
        this.currentChapter = currentChap
        this.totalChapters = totalChaps
    }

    @Override
    boolean update() {
        print('Please enter a title: ')
        title = System.in.newReader()
        print('\nPlease enter status (0 = not started, 1 = in progress, 2 = finished')
        status = System.in.newReader() as EntryStatus
        print('Please enter current chapter: ')
        currentChapter = System.in.newReader() as int
        print('Please enter total chapters: ')
        totalChapters = System.in.newReader() as int
    }

    String toCSV() {
        title + ',' + (status as int) + ',' + currentChapter + ',' + totalChapters + '\n'
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
        title + '\t' + stringStatus + '\t' + currentChapter + '/' + totalChapters
    }
}
