import pysftp
from storagemanager import save_data_to_file
from storagemanager import get_data_from_file
from ssh import commit_and_save

# Define the VyOS device details
hostname = '192.168.0.200'
username = 'vyos'
password = 'admin'
remote_path = '/config/config.boot'  # Path to the VyOS configuration file
local_path = 'data_folder/vyos2'

def pull_sftp(hostIP, uname, pwrd, remote_path="/config/config.boot"):
    # Define the connection options
    cnopts = pysftp.CnOpts()
    cnopts.hostkeys = None  # Disable host key checking (not recommended for production)

    # Connect to the VyOS device
    with pysftp.Connection(host=hostIP, username=uname, password=pwrd, cnopts=cnopts) as sftp:
        # Retrieve the configuration file
        with sftp.open(remote_path, 'r') as config_file:
            config_contents = config_file.read().decode('utf-8')

        # Print the contents of the configuration file
        #config_contents_lines = config_contents.split('\n')
        #for line in config_contents_lines:
    print(config_contents)
    save_data_to_file(config_contents, 'config.boot')

#pull_sftp(hostname, username, password, remote_path)

def push_config_via_sftp(hostname, port, username, password, local_path = 'data_folder/config.boot', remote_path = '/config/config.boot'):

    cnopts = pysftp.CnOpts()
    cnopts.hostkeys = None

    try:
        # Establish the connection
        print(f"Connecting to {hostname}:{port} as {username}...")
        with pysftp.Connection(host=hostname, username=username, password=password, port=22, cnopts=cnopts) as sftp:

            print(f"Connected to {hostname}")

            get_data_from_file('config.boot')

            # Push the local file to the remote server
            print(f"Uploading {local_path} to {remote_path}...")
            sftp.put(local_path, remote_path)
            print("File transferred successfully.")
            commit_and_save()
    except Exception as e:
        print(f"An error occurred: {e}")

#pull_sftp('192.168.0.200', 'vyos', 'admin')
#push_config_via_sftp('192.168.0.200', 22, 'vyos', 'admin')