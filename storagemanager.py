import os
from xmlmanager import convert_config_to_xml

def save_data_to_file(data, file_name, folder_name="data_folder"):
    # check folder exists and if not create
    if not os.path.exists(folder_name):
        os.makedirs(folder_name)

    # Define the file path
    file_path = os.path.join(folder_name, file_name)
    outcome = str(data)
    # Write the data to the file
    with open(file_path, 'a') as file:
        file.write(outcome + '\n')

    print(f"Data saved to {file_path}")
    return "saved"

def get_data_from_file(file_name, folder_name="data_folder"):
    # Ensure the folder exists
    if not os.path.exists(folder_name):
        print("Folder not found")

    # Define the file path
    file_path = os.path.join(folder_name, file_name)

    # Write the data to the file
    with open(file_path, 'r') as file:
        contents = file.read()

    return contents

#def send_data (file_name, folder_name="data_folder"):


def main():
    # Get user input
    option = input("1 for push 2 for pull: ")

    while option != "3":
        if option == "1":
            user_data = input("Enter the data you want to save: ")
            name = input("Enter name of file: ")
            # Save the data to a file
            save_data_to_file(user_data, name)
            break

        elif option == "2":
            selection = input("Select file to print: ")
            get_data_from_file(selection)
            break


#if __name__ == "__main__":
    #main()

