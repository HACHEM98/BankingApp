# Banking App
This project is a simple and interactive banking app interface built with Jetpack Compose in Kotlin. The app displays banking-related functionalities such as viewing cards, finance options, and currency exchange rates. The primary goal of this project is to provide a visually appealing, user-friendly UI/UX for managing and monitoring finances.
## Features
- Card Section: Display of bank cards with custom gradients and information such as card type, name, number, and balance.
- Currency Section: List of different currencies, each with current buy and sell rates and currency icons.
- Finance Section: Displays finance-related options like "My Business," "My Wallet," and "Finance Analytics."
- Wallet Section: Shows the wallet balance and includes a search option.
- Bottom Navigation Bar: Provides easy navigation across the app with sections like Home, Wallet, Notifications, and Account.
  ## Code Overview
  ### Card Section
 -  Displays a list of cards with details like card type, card name, card number, and balance.
 - Each card has a unique gradient background generated using the getGradient() function.
 - Card information is displayed in a LazyRow composable to enable horizontal scrolling.
  ### Currency Section
  - Lists available currencies with their current buy and sell rates.
  - The section can expand/collapse, displaying additional currency details.
  - Each currency item displays an icon and respective rates, all wrapped in a LazyRow composable.
  ### Finance Section
 -  Displays finance options such as "My Business," "My Wallet," and more.
 - Each finance option is represented with an icon and background color.
 - Items are scrollable horizontally within a LazyRow.
### Wallet Section
Displays the current wallet balance and includes a search icon.
The wallet balance and search icon are organized within a Row for easy readability.
### Bottom Navigation Bar
- A bottom navigation bar provides quick access to different sections.
- The navigation includes items such as Home, Wallet, Notifications, and Account.
- Icons are displayed for each navigation item, allowing users to easily switch views.
## Project Structure
- MainActivity.kt: Contains the main activity and sets the composable content.
- Composable Functions: Each section (CardSection, CurrencySection, FinanceSection, WalletSection) is implemented as a composable function, enabling reusable, modular components.
- Data Classes:
   - Card: Holds information for each card such as type, name, number, balance, and color gradient.
   - Currency: Stores details for each currency, including name, buy/sell rates, and icon.
   - Finance: Represents finance options with an icon and background color.
   - bottomNavigation: Defines the structure for bottom navigation items
