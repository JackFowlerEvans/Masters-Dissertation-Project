firewall {
    ipv4 {
        name BLOCK_ICMP {
            default-action "drop"
        }
    }
}
interfaces {
    ethernet eth0 {
        address "192.168.0.200/24"
        hw-id "00:0c:29:ad:a3:58"
    }
    ethernet eth1 {
        address "192.168.2.1/24"
        hw-id "00:0c:29:ad:a3:62"
    }
    ethernet eth2 {
        address "192.168.3.1/24"
        hw-id "00:0c:29:ad:a3:6c"
    }
    ethernet eth3 {
        address "192.168.4.1/24"
        hw-id "00:0c:29:ad:a3:76"
    }
    ethernet eth4 {
        address "192.168.5.1/24"
        address "10.0.0.1/24"
        address "10.1.0.1/24"
        address "10.2.0.1/24"
        address "10.3.0.1/24"
        address "10.4.0.1/24"
        address "10.8.0.1/24"
        hw-id "00:0c:29:ad:a3:80"
    }
    loopback lo {
    }
}
service {
    ntp {
        allow-client {
            address "127.0.0.0/8"
            address "169.254.0.0/16"
            address "10.0.0.0/8"
            address "172.16.0.0/12"
            address "192.168.0.0/16"
            address "::1/128"
            address "fe80::/10"
            address "fc00::/7"
        }
        server time1.vyos.net {
        }
        server time2.vyos.net {
        }
        server time3.vyos.net {
        }
    }
    snmp {
        community snmp_server {
            authorization "rw"
        }
    }
    ssh
}
system {
    config-management {
        commit-revisions "100"
    }
    conntrack {
        modules {
            ftp
            h323
            nfs
            pptp
            sip
            sqlnet
            tftp
        }
    }
    console {
        device ttyS0 {
            speed "115200"
        }
    }
    host-name "vyos"
    login {
        user vyos {
            authentication {
                encrypted-password "$6$rounds=656000$cF5T5GZckV9FLIfk$MVhb69XA/aGNSsVne3oVpJby56N5yLBrNXKBOcMKsBEUcnXUgUAbDa1Can1Zt791SDdfkglbmCFAld8b5xoWv1"
                plaintext-password ""
            }
        }
    }
    syslog {
        global {
            facility all {
                level "info"
            }
            facility local7 {
                level "debug"
            }
        }
    }
}


// Warning: Do not remove the following line.
// vyos-config-version: "bgp@5:broadcast-relay@1:cluster@2:config-management@1:conntrack@5:conntrack-sync@2:container@2:dhcp-relay@2:dhcp-server@8:dhcpv6-server@1:dns-dynamic@4:dns-forwarding@4:firewall@15:flow-accounting@1:https@6:ids@1:interfaces@32:ipoe-server@3:ipsec@13:isis@3:l2tp@9:lldp@2:mdns@1:monitoring@1:nat@8:nat66@3:ntp@3:openconnect@3:ospf@2:pim@1:policy@8:pppoe-server@10:pptp@5:qos@2:quagga@11:reverse-proxy@1:rip@1:rpki@2:salt@1:snmp@3:ssh@2:sstp@6:system@27:vrf@3:vrrp@4:vyos-accel-ppp@2:wanloadbalance@3:webproxy@2"
// Release version: 1.4.0

firewall {
    ipv4 {
        name BLOCK_ICMP {
            default-action "drop"
        }
    }
}
interfaces {
    ethernet eth0 {
        address "192.168.0.200/24"
        hw-id "00:0c:29:ad:a3:58"
    }
    ethernet eth1 {
        address "192.168.2.1/24"
        hw-id "00:0c:29:ad:a3:62"
    }
    ethernet eth2 {
        address "192.168.3.1/24"
        hw-id "00:0c:29:ad:a3:6c"
    }
    ethernet eth3 {
        address "192.168.4.1/24"
        hw-id "00:0c:29:ad:a3:76"
    }
    ethernet eth4 {
        address "192.168.5.1/24"
        address "10.0.0.1/24"
        address "10.1.0.1/24"
        address "10.2.0.1/24"
        address "10.3.0.1/24"
        address "10.4.0.1/24"
        address "10.8.0.1/24"
        hw-id "00:0c:29:ad:a3:80"
    }
    loopback lo {
    }
}
service {
    ntp {
        allow-client {
            address "127.0.0.0/8"
            address "169.254.0.0/16"
            address "10.0.0.0/8"
            address "172.16.0.0/12"
            address "192.168.0.0/16"
            address "::1/128"
            address "fe80::/10"
            address "fc00::/7"
        }
        server time1.vyos.net {
        }
        server time2.vyos.net {
        }
        server time3.vyos.net {
        }
    }
    snmp {
        community snmp_server {
            authorization "rw"
        }
    }
    ssh
}
system {
    config-management {
        commit-revisions "100"
    }
    conntrack {
        modules {
            ftp
            h323
            nfs
            pptp
            sip
            sqlnet
            tftp
        }
    }
    console {
        device ttyS0 {
            speed "115200"
        }
    }
    host-name "vyos"
    login {
        user vyos {
            authentication {
                encrypted-password "$6$rounds=656000$cF5T5GZckV9FLIfk$MVhb69XA/aGNSsVne3oVpJby56N5yLBrNXKBOcMKsBEUcnXUgUAbDa1Can1Zt791SDdfkglbmCFAld8b5xoWv1"
                plaintext-password ""
            }
        }
    }
    syslog {
        global {
            facility all {
                level "info"
            }
            facility local7 {
                level "debug"
            }
        }
    }
}


// Warning: Do not remove the following line.
// vyos-config-version: "bgp@5:broadcast-relay@1:cluster@2:config-management@1:conntrack@5:conntrack-sync@2:container@2:dhcp-relay@2:dhcp-server@8:dhcpv6-server@1:dns-dynamic@4:dns-forwarding@4:firewall@15:flow-accounting@1:https@6:ids@1:interfaces@32:ipoe-server@3:ipsec@13:isis@3:l2tp@9:lldp@2:mdns@1:monitoring@1:nat@8:nat66@3:ntp@3:openconnect@3:ospf@2:pim@1:policy@8:pppoe-server@10:pptp@5:qos@2:quagga@11:reverse-proxy@1:rip@1:rpki@2:salt@1:snmp@3:ssh@2:sstp@6:system@27:vrf@3:vrrp@4:vyos-accel-ppp@2:wanloadbalance@3:webproxy@2"
// Release version: 1.4.0


firewall {
    ipv4 {
        name BLOCK_ICMP {
            default-action "drop"
        }
    }
}
interfaces {
    ethernet eth0 {
        address "192.168.0.200/24"
        hw-id "00:0c:29:ad:a3:58"
    }
    ethernet eth1 {
        address "192.168.2.1/24"
        hw-id "00:0c:29:ad:a3:62"
    }
    ethernet eth2 {
        address "192.168.3.1/24"
        hw-id "00:0c:29:ad:a3:6c"
    }
    ethernet eth3 {
        address "192.168.4.1/24"
        hw-id "00:0c:29:ad:a3:76"
    }
    ethernet eth4 {
        address "192.168.5.1/24"
        address "10.0.0.1/24"
        address "10.1.0.1/24"
        address "10.2.0.1/24"
        address "10.3.0.1/24"
        address "10.4.0.1/24"
        address "10.8.0.1/24"
        hw-id "00:0c:29:ad:a3:80"
    }
    loopback lo {
    }
}
service {
    ntp {
        allow-client {
            address "127.0.0.0/8"
            address "169.254.0.0/16"
            address "10.0.0.0/8"
            address "172.16.0.0/12"
            address "192.168.0.0/16"
            address "::1/128"
            address "fe80::/10"
            address "fc00::/7"
        }
        server time1.vyos.net {
        }
        server time2.vyos.net {
        }
        server time3.vyos.net {
        }
    }
    snmp {
        community snmp_server {
            authorization "rw"
        }
    }
    ssh
}
system {
    config-management {
        commit-revisions "100"
    }
    conntrack {
        modules {
            ftp
            h323
            nfs
            pptp
            sip
            sqlnet
            tftp
        }
    }
    console {
        device ttyS0 {
            speed "115200"
        }
    }
    host-name "vyos"
    login {
        user vyos {
            authentication {
                encrypted-password "$6$rounds=656000$cF5T5GZckV9FLIfk$MVhb69XA/aGNSsVne3oVpJby56N5yLBrNXKBOcMKsBEUcnXUgUAbDa1Can1Zt791SDdfkglbmCFAld8b5xoWv1"
                plaintext-password ""
            }
        }
    }
    syslog {
        global {
            facility all {
                level "info"
            }
            facility local7 {
                level "debug"
            }
        }
    }
}


// Warning: Do not remove the following line.
// vyos-config-version: "bgp@5:broadcast-relay@1:cluster@2:config-management@1:conntrack@5:conntrack-sync@2:container@2:dhcp-relay@2:dhcp-server@8:dhcpv6-server@1:dns-dynamic@4:dns-forwarding@4:firewall@15:flow-accounting@1:https@6:ids@1:interfaces@32:ipoe-server@3:ipsec@13:isis@3:l2tp@9:lldp@2:mdns@1:monitoring@1:nat@8:nat66@3:ntp@3:openconnect@3:ospf@2:pim@1:policy@8:pppoe-server@10:pptp@5:qos@2:quagga@11:reverse-proxy@1:rip@1:rpki@2:salt@1:snmp@3:ssh@2:sstp@6:system@27:vrf@3:vrrp@4:vyos-accel-ppp@2:wanloadbalance@3:webproxy@2"
// Release version: 1.4.0


firewall {
    ipv4 {
        name BLOCK_ICMP {
            default-action "drop"
        }
    }
}
interfaces {
    ethernet eth0 {
        address "192.168.0.200/24"
        hw-id "00:0c:29:ad:a3:58"
    }
    ethernet eth1 {
        address "192.168.2.1/24"
        hw-id "00:0c:29:ad:a3:62"
    }
    ethernet eth2 {
        address "192.168.3.1/24"
        hw-id "00:0c:29:ad:a3:6c"
    }
    ethernet eth3 {
        address "192.168.4.1/24"
        hw-id "00:0c:29:ad:a3:76"
    }
    ethernet eth4 {
        address "192.168.5.1/24"
        address "10.0.0.1/24"
        address "10.1.0.1/24"
        address "10.2.0.1/24"
        address "10.3.0.1/24"
        address "10.4.0.1/24"
        address "10.8.0.1/24"
        hw-id "00:0c:29:ad:a3:80"
    }
    loopback lo {
    }
}
service {
    ntp {
        allow-client {
            address "127.0.0.0/8"
            address "169.254.0.0/16"
            address "10.0.0.0/8"
            address "172.16.0.0/12"
            address "192.168.0.0/16"
            address "::1/128"
            address "fe80::/10"
            address "fc00::/7"
        }
        server time1.vyos.net {
        }
        server time2.vyos.net {
        }
        server time3.vyos.net {
        }
    }
    snmp {
        community snmp_server {
            authorization "rw"
        }
    }
    ssh
}
system {
    config-management {
        commit-revisions "100"
    }
    conntrack {
        modules {
            ftp
            h323
            nfs
            pptp
            sip
            sqlnet
            tftp
        }
    }
    console {
        device ttyS0 {
            speed "115200"
        }
    }
    host-name "vyos"
    login {
        user vyos {
            authentication {
                encrypted-password "$6$rounds=656000$cF5T5GZckV9FLIfk$MVhb69XA/aGNSsVne3oVpJby56N5yLBrNXKBOcMKsBEUcnXUgUAbDa1Can1Zt791SDdfkglbmCFAld8b5xoWv1"
                plaintext-password ""
            }
        }
    }
    syslog {
        global {
            facility all {
                level "info"
            }
            facility local7 {
                level "debug"
            }
        }
    }
}


// Warning: Do not remove the following line.
// vyos-config-version: "bgp@5:broadcast-relay@1:cluster@2:config-management@1:conntrack@5:conntrack-sync@2:container@2:dhcp-relay@2:dhcp-server@8:dhcpv6-server@1:dns-dynamic@4:dns-forwarding@4:firewall@15:flow-accounting@1:https@6:ids@1:interfaces@32:ipoe-server@3:ipsec@13:isis@3:l2tp@9:lldp@2:mdns@1:monitoring@1:nat@8:nat66@3:ntp@3:openconnect@3:ospf@2:pim@1:policy@8:pppoe-server@10:pptp@5:qos@2:quagga@11:reverse-proxy@1:rip@1:rpki@2:salt@1:snmp@3:ssh@2:sstp@6:system@27:vrf@3:vrrp@4:vyos-accel-ppp@2:wanloadbalance@3:webproxy@2"
// Release version: 1.4.0


<class 'tkinter.Text'>
