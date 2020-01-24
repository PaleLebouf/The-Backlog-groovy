class Menu {

    void printTitle() {
        println('-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-')
        println('\tThe Backlog')
        println('-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-')
    }

    public void printMainMenu() {
        printTitle()
        println()
        println('-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-')
        println('\nWelcome to the backlog, please enter a number to begin:\n')
        println('1. View Backlog')
        println('2. Add Entry')
        println('3. Update Entry')
        println('4. Delete Entry')
        println('5. Choose Something To Do')
        println('6. Exit')
        println('-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-')
    }

    void printViewOptions() {
        println("\033[H\033[2J")
        println('-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-')
        println('\nPlease choose a category:\n')
        println('1. Games')
        println('2. Anime')
        println('3. Manga')
        println('4. Western Shows')
        println('-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-')
    }

    public String promptInput(String prompt) {
        print(prompt)
        System.in.newReader().readLine()
    }

}
