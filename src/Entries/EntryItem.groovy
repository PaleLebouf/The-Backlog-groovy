package Entries

interface EntryItem {

    String title
    EntryStatus status

    boolean update()

    String toCSV()

    String toString()

}
