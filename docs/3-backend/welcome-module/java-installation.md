

# Java Installation:

To install Java you need to install Java Development Toolkit (JDK).
JDK includes both a Java Runtime Environment (JRE) and a Java Virtual Machine (JVM). These are all you need to develop and run your java applications.
The JDK also includes a number of programming tools, like a compiler and a Java web server, for programmers who need to install Java on Windows.We will discuss more about JDK in upcoming lessons.

#### We will install Eclipse Temurin JDK17 because it is an LTS version with extended support till September 2029.
LTS stands for Long Term Support, which means it will be supported for a longer period.

##### If you have any other preferences for JDK installation, feel free to choose an alternative.

# Installation Steps for Eclipse Temurin JDK 17 (LTS)

## For Windows:

### 1. Download Eclipse Temurin JDK 17
- Go to the official <a href="https://adoptium.net/temurin/releases/?version=17" target="_blank">Eclipse Temurin Website</a>
- Under the **Choose a Version** section, select:
  - **Version**: 17 (LTS)
  - **Operating System**: Windows
  - **Architecture**: x64 (for 64-bit systems)
- Download the **.msi** installer (Windows Installer) by clicking the **Download** button.

### 2. Install Eclipse Temurin JDK 17
- Once the download is complete, locate the `.msi` file in your **Downloads** folder and double-click it to start the installation.
- Follow the installation steps:
  1. **Welcome screen**: Click **Next**.
  2. **License Agreement**: Read the agreement and accept it by checking the box, then click **Next**.
  3. **Installation Folder**: You can choose the default installation path (e.g., `C:\Program Files\Eclipse Adoptium\jdk-17`) or select a custom path. Click **Next**.
  4. **Set Environment Variables**: Make sure the options to set the `JAVA_HOME` variable and add the JDK to the `PATH` are selected (this will make it easier to use the JDK from the command line).
  5. **Installation**: Click **Install** to begin the installation process.
  
- Wait for the installation to complete and click **Finish**.

### 3. Verify Installation
- After installation, it's important to verify that the JDK has been installed correctly:
  1. Open **Command Prompt**:
     - Press `Win + R`, type `cmd`, and press **Enter**.
  2. Type the following command to check the version of Java:
     ```bash
     java -version
     ```
  3. You should see output similar to this:
     ```
     openjdk version "17.0.2" 2022-01-18
     OpenJDK Runtime Environment Temurin-17+35 (build 17.0.2+8)
     OpenJDK 64-Bit Server VM Temurin-17+35 (build 17.0.2+8, mixed mode, sharing)
     ```

#### 4. You can refer to following video for more support on how to install Adoptium JDK on Windows (Optional)  (Optional):

<iframe width="560" height="315" src="https://www.youtube.com/embed/JlLvyzuSyFU?si=qy5_PwfSVby21dvQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

 
## For macOS:

### 1. Download Eclipse Temurin JDK 17
- Visit the <a href="https://adoptium.net/temurin/releases/?version=17" target="_blank">Eclipse Temurin download page</a>
- Select the following:
  - **Version**: 17 (LTS)
  - **Operating System**: macOS
  - **Architecture**: Choose based on your Mac's architecture:
    - **x64** for Intel-based Macs.
    - **aarch64** for M1/M2 Apple Silicon Macs.
- Download the `.pkg` installer by clicking the **Download** button.

### 2. Install Eclipse Temurin JDK 17
- Once the download completes, locate the `.pkg` file in your **Downloads** folder and double-click it to start the installation.
- Follow these steps:
  1. **Introduction**: Click **Continue**.
  2. **License Agreement**: Read and accept the agreement by clicking **Continue** and then **Agree**.
  3. **Installation Folder**: The installer will select the default location. Click **Install**.
  4. **Administrator Password**: You may need to enter your macOS password to authorize the installation.
  5. **Installation**: Click **Install Software** to begin the installation process.
  
- Wait for the installation to complete and click **Close**.

### 3. Set JAVA_HOME Environment Variable (Optional)
- The `JAVA_HOME` environment variable is used by many development tools to locate the JDK. Setting this variable ensures your development environment knows which JDK to use.
- Open the **Terminal** application.
- Add the following line to your shell configuration file (`.zshrc` for zsh or `.bash_profile` for bash):
  ```bash
  export JAVA_HOME=$(/usr/libexec/java_home -v 17)
  ```
- Apply the changes by running:
  ```bash
  source ~/.zshrc   # or source ~/.bash_profile
  ```

### 4. Verify Installation
- Open **Terminal** and run:
  ```bash
  java -version
  ```
- You should see output similar to this:
  ```
  openjdk version "17.0.2" 2022-01-18
  OpenJDK Runtime Environment Temurin-17+35 (build 17.0.2+8)
  OpenJDK 64-Bit Server VM Temurin-17+35 (build 17.0.2+8, mixed mode, sharing)

  ```

#### 5.Troubleshooting

- **Environment Variable Not Set**: Ensure the `JAVA_HOME` path is set correctly. You can verify by running:
  ```bash
  echo $JAVA_HOME
  

#### 6. You may refer to following video for more support on how to install Adoptium JDK on Mac OS (Optional) :

<iframe width="560" height="315" src="https://www.youtube.com/embed/m3vR0aALrtY?si=mErhLKwWKS7q6G0a" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>


## Install Extension Pack for Java

Once you have VSCode and JDK intalled,there are collection of extensions that you need to install to help you write Java code in VSCode. You can install it from the following link:

Visit the <a href="https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack" target="_blank">Extension Pack for Java</a>



---

## Post-Installation Tips

- **Eclipse Temurin JDK 17** is now installed on your system. You can use it to compile and run Java programs from the command line or integrate it into your favorite Integrated Development Environment (IDE) such as **IntelliJ IDEA**, **Eclipse**, or **Visual Studio Code**.
- If you're using an IDE:
   - Make sure to configure the IDE to point to your newly installed JDK.
   - For IntelliJ IDEA, navigate to **File** > **Project Structure** > **Project SDK** and add the JDK 17.
   - For Eclipse, go to **Window** > **Preferences** > **Java** > **Installed JREs** and add the JDK 17.
