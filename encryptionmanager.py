from lxml import etree
from cryptography.fernet import Fernet
import os

# Function to generate a key and save it into a file
def generate_key():
    key = Fernet.generate_key()
    with open("secret.key", "wb") as key_file:
        key_file.write(key)

# Function to load the key from the current directory named `secret.key`
def load_key():
    return open("secret.key", "rb").read()

# Function to encrypt a message
def encrypt_message(message, key):
    f = Fernet(key)
    encrypted_message = f.encrypt(message.encode())
    return encrypted_message

# Function to decrypt a message
def decrypt_message(encrypted_message, key):
    f = Fernet(key)
    decrypted_message = f.decrypt(encrypted_message).decode()
    return decrypted_message

# Function to encrypt the XML file
def encrypt_xml(file_path):
    # Load the key
    key = load_key()

    # Parse the XML file
    tree = etree.parse(file_path)
    root = tree.getroot()

    # Encrypt the text of each element
    for elem in root.iter():
        if elem.text:
            elem.text = encrypt_message(elem.text, key).decode()

    # Write the encrypted XML back to the file
    tree.write(file_path, pretty_print=True, xml_declaration=True, encoding="UTF-8")

# Generate a key if it doesn't exist
if not os.path.exists("secret.key"):
    generate_key()

# Path to the XML file
xml_file_path = "data_folder/config.xml"
key = "/secret.key"
# Encrypt the XML file
encrypt_xml(xml_file_path)
#plain = decrypt_message(xml_file_path, key)

