class Main {

    static void main(String[] args) {
        int currentChoice
        Menu menu = new Menu()
        Database db = new Database()

        while (currentChoice.toInteger() != 6) {
            menu.printMainMenu()
            currentChoice = menu.promptInput("Pick a menu option from 1 to 4") as int
            if (currentChoice > 6 || currentChoice < 1) {
                println('Please enter an option from 1 to 6: ')
            } else if (currentChoice == 1) {

            } else if (currentChoice == 2) {

            } else if (currentChoice == 3) {

            } else if (currentChoice == 4) {

            } else if (currentChoice == 5) {

            } else if (currentChoice == 6) {

            }

        }

    }

}
