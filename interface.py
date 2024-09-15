from tkinter import *
from tkinter import scrolledtext
from tkinter.scrolledtext import ScrolledText

# Interface imports
from storagemanager import get_data_from_file
from storagemanager import save_data_to_file

# SFTP imports
from sftp import pull_sftp
from sftp import push_config_via_sftp

# SSH imports
from ssh import ssh

# SNMP imports

# Used for show config button
def display_file_contents():
    contents = get_data_from_file('config.boot')
    output_window = Toplevel(interface)
    output_window.title("Config File Output")
    text_area = Text(output_window, wrap=NONE, width=80, height=20)
    text_area.pack(expand=True, fill='both')

    if isinstance(contents, list):
        for line in contents:
            text_area.insert(END, line)
    else:
        text_area.insert(END, contents)

    scrollbar = Scrollbar(output_window, command=text_area.yview)
    text_area.config(yscrollcommand=scrollbar.set)
    scrollbar.pack(side=RIGHT, fill=Y)

    save_button = Button(text_area, text='Save', command=save)
    save_button.pack(side=BOTTOM)
def save():
    save_data_to_file(Text, 'config.boot', folder_name="data_folder")

# For SFTP functionality
def sftp_pull():
    pull_sftp('192.168.0.200', 'vyos', 'admin')

def sftp_push():
    push_config_via_sftp('192.168.0.200', 22, 'vyos', 'admin')

# For SSH functionality
def ssh_push_and_pull():
    ssh()


interface = Tk()
interface.geometry('500x500')
interface.title('System Interface')

# Frames
sshframe = LabelFrame(interface, text='SSH')
sshframe.grid(row=0, column=0, padx=5, pady=5)

sftpframe = LabelFrame(interface, text='SFTP')
sftpframe.grid(row=0, column=1, padx=5, pady=5)

snmpframe = LabelFrame(interface, text='SNMP')
snmpframe.grid(row=0, column=2, padx=5, pady=5)

viewframe = LabelFrame(interface, text='View')
viewframe.grid(row=0, column=3, padx=5, pady=5)


# SSH section
ssh_pull = Button(sshframe, text='Pull')
ssh_pull.pack(pady=20, padx=20)

ssh_push = Button(sshframe, text='Push', command=ssh_push_and_pull)
ssh_push.pack(pady=20, padx=20)

# SFTP section
sftp_pull = Button(sftpframe, text='Pull', command=sftp_pull)
sftp_pull.pack(pady=20, padx=20)

sftp_push = Button(sftpframe, text='Push', command=sftp_push)
sftp_push.pack(pady=20, padx=20)

# SNMP section
snmp_pull = Button(snmpframe, text='Pull')
snmp_pull.pack(pady=20, padx=20)

snmp_push = Button(snmpframe, text='Push')
snmp_push.pack(pady=20, padx=20)

#output_label = Label(interface, text='')
#output_label.grid(row=0, column=0, padx=20, pady=20)

# view data section
view_data = Button(viewframe, text='View', command=display_file_contents)
view_data.grid(row=1, column=0, padx=20, pady=53)


interface.mainloop()