
### Animated Clock with Jetpack Compose

A visually appealing and dynamic clock built using Jetpack Compose in Kotlin. This project demonstrates how to create a fully functional animated clock with smooth transitions, real-time updates, and a customizable UI. The goal is to provide a practical example of animations and state management in Jetpack Compose.

----------

### 🚀 Features

-   **Real-Time Updates**: The clock updates in real-time, with the second, minute, and hour hands animated smoothly.
-   **Customizable UI**: Elegant and minimalistic design with a gradient background.
-   **Dynamic Rotation**: The hands of the clock are accurately synchronized based on elapsed time.
-   **Scalable Design**: Uses responsive dimensions to ensure proper scaling across devices.
-   **Jetpack Compose**: Built entirely using Jetpack Compose for a modern declarative UI approach.

----------
### DEMO 

https://github.com/user-attachments/assets/0140caf4-7e70-4f55-ad34-81a06d5824e5

----------

### 📂 Project Structure

This project is organized for clarity and scalability:

#### **Presentation Layer (presentation)**

-   **`ClockScreen`**: The main composable that integrates the clock UI and handles time updates.
-   **Canvas-Based Clock**: Uses `Canvas` to draw the clock hands and the circular border.

#### **UI Components**

-   **Clock Hands**: Custom-drawn minute and hour hands with distinct styles.
-   **Text Display**: A large digital clock display showing the current time in `HH:mm` format.
-   **Background Gradient**: A vertical gradient background for a polished look.

----------

### 📋 Requirements

-   **Android 8.0 (API 26)** or higher.
-   **Kotlin 1.8** or higher.
-   **Jetpack Compose 1.4** or higher.

----------

### 🛠 How to Use

1.  **Clone the repository:**

    
    `git clone https://github.com/your-username/animated-clock-compose.git` 
    
2.  **Open the project** in Android Studio.
    
3.  **Run the project** on an emulator or a physical device.
    
4.  The `ClockScreen` composable will display an animated clock with real-time updates.
    

----------

### 💡 How It Works

-   **Time Management**:
    -   A `totalMinutes` state tracks the number of elapsed minutes, incremented every second using a coroutine.
    -   Hours and minutes are derived from `totalMinutes` and are used to calculate the rotation of the clock hands.
-   **Canvas Drawing**:
    -   `Canvas` is used to draw the clock hands and border dynamically, with precise alignment and scaling.
-   **Background**:
    -   A gradient background is applied using `Brush.verticalGradient` for a modern aesthetic.

----------

### 🎨 Customization

You can easily customize the clock's appearance:

-   **Colors**: Adjust the background gradient, hand colors, or text colors in the `ClockScreen` composable.
-   **Sizes**: Modify the `Canvas` size or the proportions of the clock hands.

----------

### 🤝 Contributing

We welcome contributions! If you find a bug or have ideas for new features, feel free to open an issue or submit a pull request.

----------

### 📜 License

This project is licensed under the MIT License. See the `LICENSE` file for details.

----------

🎉 **Enjoy creating with Jetpack Compose!**
