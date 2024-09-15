from netmiko import ConnectHandler

vyos = {
    "device_type": "vyos",
    "host": "192.168.0.200",
    "username": "vyos",
    "password": "admin",
    "port": 22,
    }

def ssh():
    net_connect = ConnectHandler(**vyos)

    commands = [
        'set interfaces ethernet eth4 address 10.8.0.1/24'
    ]
    net_connect.enable()

    output = net_connect.send_config_set(commands, exit_config_mode=False, read_timeout=20)

    #output = net_connect.send_command('set interfaces ethernet eth4 address 10.1.0.1/24')
    commit = net_connect.send_command('commit')
    save = net_connect.send_command('save')
    print(output)
    net_connect.disconnect()

def commit_and_save():
    net_connect = ConnectHandler(**vyos)
    net_connect.enable()
    net_connect.send_command('commit')
    net_connect.send_command('save')
    net_connect.disconnect()
    return
