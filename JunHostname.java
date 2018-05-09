configure
show | match host-name
edit system
set host-name JunOS


<rpc-reply xmlns:junos="http://xml.juniper.net/junos/15.1X49/junos">
    <configuration junos:commit-seconds="1523858686" junos:commit-localtime="2018-04-16 06:04:46 UTC" junos:commit-user="admin">
            <system>
                <host-name>a.b</host-name>
            </system>
    </configuration>
    <cli>
        <banner>[edit]</banner>
    </cli>
</rpc-reply>

------------------------archive-----------------------------
set system syslog archive binary-data files 222 no-world-readable size 222222  这一句是在juniper上执行的
下面是执行后显示的效果
set system syslog archive size 222222
set system syslog archive files 222
set system syslog archive no-world-readable    //和world readable是相对立的，只会出现其中之一，但是命令还是可以下发下去的，只不过是被覆盖了而已
set system syslog archive binary-data		//对立no binary data

admin@a.b# set system syslog archive ?
Possible completions:
  <[Enter]>            Execute this command
  binary-data          Mark file as if it contains binary data
  files                Number of files to be archived (1..1000)
  no-binary-data       Don't mark file as if it contains binary data
  no-world-readable    Don't allow any user to read the log file  
  size                 Size of files to be archived (65536..1073741824 bytes)
  world-readable       Allow any user to read the log file


--------------------------------------------console----------------------------------------------------
set system syslog console any any
set system syslog console authorization critical
set system syslog console daemon alert
set system syslog console ftp warning
set system syslog console ntp critical
set system syslog console security error
set system syslog console kernel any
set system syslog console user info
set system syslog console dfc info
set system syslog console external none
set system syslog console firewall notice
set system syslog console pfe emergency
set system syslog console conflict-log error
set system syslog console change-log emergency
set system syslog console interactive-commands alert

console 后面的第一个参数
any                  All facilities
authorization        Authorization system
change-log           Configuration change log
conflict-log         Configuration conflict log
daemon               Various system processes
dfc                  Dynamic flow capture
external             Local external applications
firewall             Firewall filtering system
ftp                  FTP process
interactive-commands  Commands executed by the UI
kernel               Kernel
ntp                  NTP process
pfe                  Packet Forwarding Engine
security             Security related
user                 User processes


  
console 后面的第二个参数
  alert                Conditions that should be corrected immediately
  any                  All levels
  critical             Critical conditions
  emergency            Panic conditions
  error                Error conditions
  info                 Informational messages
  none                 No messages
  notice               Conditions that should be handled specially
  warning              Warning messages
  
  
  -----------------------file--------------------------
admin@a.b# set system syslog file messa ?
Possible completions:
  allow-duplicates     Do not suppress the repeated message
  any                  All facilities
+ apply-groups         Groups from which to inherit configuration data
+ apply-groups-except  Don't inherit configuration data from these groups
> archive              Archive file information
  authorization        Authorization system
  change-log           Configuration change log
  conflict-log         Configuration conflict log
  daemon               Various system processes
  dfc                  Dynamic flow capture
  explicit-priority    Include priority and facility in messages
  external             Local external applications
  firewall             Firewall filtering system
  ftp                  FTP process
  interactive-commands  Commands executed by the UI
  kernel               Kernel
  match                Regular expression for lines to be logged
  ntp                  NTP process
  pfe                  Packet Forwarding Engine
  security             Security related
> structured-data      Log system message in structured format
  user                 User processes
[edit]

file 里面除了几个不同的第一参数，其他第一参数的第二参数都是下面的这个参数表
  alert                Conditions that should be corrected immediately
  any                  All levels
  critical             Critical conditions
  emergency            Panic conditions
  error                Error conditions
  info                 Informational messages
  none                 No messages
  notice               Conditions that should be handled specially
  warning              Warning messages
2147483647
1073741824
admin@a.b# set system syslog file messa archive ?
Possible completions:
  <[Enter]>            Execute this command
> archive-sites        
  binary-data          Mark file as if it contains binary data
  files                Number of files to be archived (1..1000)
  no-binary-data       Don't mark file as if it contains binary data
  no-world-readable    Don't allow any user to read the log file
  size                 Size of files to be archived (65536..1073741824 bytes)
  start-time           Start time for file transmission (yyyy-mm-dd.hh:mm)
  transfer-interval    Frequency at which to transfer files to archive sites (5..2880 minutes)
  world-readable       Allow any user to read the log file
  
admin@a.b# set system syslog file messa archive archive-sites www.hehe.com 
admin@a.b# set system syslog file messa archive start-time 1999-12-12.11:22
set system syslog file messa archive transfer-interval 222

set system syslog file messa structured-data brief
admin@a.b# set system syslog file messa structured-data ?
Possible completions:
  <[Enter]>            Execute this command
+ apply-groups         Groups from which to inherit configuration data
+ apply-groups-except  Don't inherit configuration data from these groups
  brief                Omit English-language text from end of logged message
  |                    Pipe through a command
[edit]


---------------------------------host-------------------------------------------------------
host后面的参数和routing的参数是一致的
admin@a.b# set system syslog host ?
Possible completions:
  <log-host-name>      Host to be notified
  192.168.1.40         Host to be notified
  2.2.2.2              Host to be notified
  other-routing-engine  Send to log file on other Routing Engine
  
admin@a.b# set system syslog host other-routing-engine ?
Possible completions:
  allow-duplicates     Do not suppress the repeated message
  any                  All facilities
+ apply-groups         Groups from which to inherit configuration data
+ apply-groups-except  Don't inherit configuration data from these groups
  authorization        Authorization system
  change-log           Configuration change log
  conflict-log         Configuration conflict log
  daemon               Various system processes
  dfc                  Dynamic flow capture
  exclude-hostname     Exclude hostname field in messages
  explicit-priority    Include priority and facility in messages
  external             Local external applications
  facility-override    Alternate facility for logging to remote host
  firewall             Firewall filtering system
  ftp                  FTP process
  interactive-commands  Commands executed by the UI
  kernel               Kernel
  log-prefix           Prefix for all logging to this host
  match                Regular expression for lines to be logged
  ntp                  NTP process
  pfe                  Packet Forwarding Engine
  port                 Port number
  security             Security related
  source-address       Use specified address as source address
> structured-data      Log system message in structured format
  user                 User processes
[edit]


  
  
  authorization        Authorization system
  daemon               Various system processes
  ftp                  FTP process
  kernel               Kernel
  local0               Local logging option number 0
  local1               Local logging option number 1
  local2               Local logging option number 2
  local3               Local logging option number 3
  local4               Local logging option number 4
  local5               Local logging option number 5
  local6               Local logging option number 6
  local7               Local logging option number 7
  user                 User processes

---------------------------------server------------------------------------------------
Syslog server can be enabled only when app-engine is configured

set system syslog server routing-instances hh disable
  
这三个参数后面都可以跟一个disable
  admin@a.b# set system syslog server routing-instances ?        
Possible completions:
  <instance-name>      Routing instance name
  all                  All routing instances
  default              Default routing instance

  ---------------------------------time-format----------------------------------------------
三个参数都可以设置，当设置了year或者millisecond的时候，time-format就会被隐藏，只出现 year或者millisecond
 admin@a.b# set system syslog time-format ?
Possible completions:
  <[Enter]>            Execute this command
  millisecond          Include milliseconds in timestamp
  year                 Include year in timestamp
  |                    Pipe through a command
  
   ---------------------------------user----------------------------------------------	多个
admin@a.b# set system syslog user hh ?
Possible completions:
  allow-duplicates     Do not suppress the repeated message
  any                  All facilities
+ apply-groups         Groups from which to inherit configuration data
+ apply-groups-except  Don't inherit configuration data from these groups
  authorization        Authorization system
  change-log           Configuration change log
  conflict-log         Configuration conflict log
  daemon               Various system processes
  dfc                  Dynamic flow capture
  external             Local external applications
  firewall             Firewall filtering system
  ftp                  FTP process
  interactive-commands  Commands executed by the UI
  kernel               Kernel
  match                Regular expression for lines to be logged
  ntp                  NTP process
  pfe                  Packet Forwarding Engine
  security             Security related
  user                 User processes
[edit]
admin@a.b# set system syslog user hh 

admin@a.b# set system syslog user hh kernel ?            
Possible completions:
  alert                Conditions that should be corrected immediately
  any                  All levels
  critical             Critical conditions
  emergency            Panic conditions
  error                Error conditions
  info                 Informational messages
  none                 No messages
  notice               Conditions that should be handled specially
  warning              Warning messages
[edit]

--------------------其他syslog级别的参数--------------------------------------

set system syslog log-rotate-frequency 55
set system syslog allow-duplicates






set system syslog archive size 222222
set system syslog archive files 222
set system syslog archive world-readable
set system syslog archive binary-data
set system syslog user * any emergency
set system syslog user mt allow-duplicates
set system syslog host 192.168.1.40 any notice
set system syslog host 192.168.1.40 port 5514
set system syslog host 192.168.1.40 log-prefix "$UUID"
set system syslog host 2.2.2.2 any any
set system syslog allow-duplicates
set system syslog file messages any any
set system syslog file messages authorization info
set system syslog file interactive-commands interactive-commands any
set system syslog file messa any alert
set system syslog file messa allow-duplicates
set system syslog file messa archive transfer-interval 222
set system syslog file messa archive start-time "1999-12-12.11:22:00 +0000"
set system syslog file messa archive archive-sites www.hehe.com
set system syslog file messa structured-data brief
set system syslog console any any
set system syslog console authorization critical
set system syslog console daemon alert
set system syslog console ftp warning
set system syslog console ntp critical
set system syslog console security error
set system syslog console kernel any
set system syslog console user info
set system syslog console dfc info
set system syslog console external none
set system syslog console firewall notice
set system syslog console pfe emergency
set system syslog console conflict-log error
set system syslog console change-log emergency
set system syslog console interactive-commands alert
set system syslog time-format year
set system syslog time-format millisecond
set system syslog source-address 2.2.2.2
set system syslog log-rotate-frequency 55



^[0-9A-Za-z][\.0-9A-Za-z_-]*(\.)*[0-9A-Za-z][\.0-9A-Za-z_-]*$
<rpc-reply xmlns:junos="http://xml.juniper.net/junos/15.1X49/junos">
    <configuration junos:commit-seconds="1525675580" junos:commit-localtime="2018-05-07 06:46:20 UTC" junos:commit-user="admin">
            <system>
                <syslog>
                    <archive>
                        <size>222222</size>
                        <files>222</files>
                        <world-readable/>
                        <binary-data/>
                    </archive>
                    <user>
                        <name>*</name>
                        <contents>
                            <name>any</name>
                            <emergency/>
                        </contents>
                    </user>
                    <user>
                        <name>mt</name>
                        <contents>
                            <name>authorization</name>
                            <critical/>
                        </contents>
                        <contents>
                            <name>daemon</name>
                            <info/>
                        </contents>
                        <allow-duplicates/>
                    </user>

                    <host>
                        <name>192.168.1.40</name>
                        <contents>
                            <name>any</name>
                            <notice/>
                        </contents>
                        <port>5514</port>
                        <log-prefix>$UUID</log-prefix>
                    </host>
                    <host>
                        <name>2.2.2.2</name>
                        <contents>
                            <name>any</name>
                            <any/>      
                        </contents>
                    </host>
					<host>
                        <name>heh</name>
                        <contents>
                            <name>any</name>
                            <any/>
                        </contents>
                        <contents>
                            <name>kernel</name>
                            <notice/>
                        </contents>
                        <contents>
                            <name>firewall</name>
                            <info/>
                        </contents>
                        <contents>
                            <name>change-log</name>
                            <none/>
                        </contents>
                        <port>111</port>
                        <facility-override>ftp</facility-override>
                        <log-prefix>hh</log-prefix>
                        <source-address>1.1.1.1</source-address>
                        <exclude-hostname/>
                    </host>
					
                    <allow-duplicates/>
					
                    <file>
                        <name>messages</name>
                        <contents>
                            <name>any</name>
                            <any/>
                        </contents>
                        <contents>
                            <name>authorization</name>
                            <info/>
                        </contents>
                    </file>
                    <file>
                        <name>interactive-commands</name>
                        <contents>
                            <name>interactive-commands</name>
                            <any/>
                        </contents>
                    </file>
                    <file>
                        <name>messa</name>
                        <contents>
                            <name>any</name>
                            <alert/>
                        </contents>
                        <allow-duplicates/>
                        <archive>
                            <transfer-interval>222</transfer-interval>	
                            <start-time>1999-12-12.11:22:00 +0000</start-time>
                            <archive-sites>
                                <name>www.hehe.com</name>
                            </archive-sites>
                        </archive>
                        <structured-data>
                            <brief/>
                        </structured-data>
                    </file>
                    <console>
                        <name>any</name>
                        <any/>
                    </console>
                    <console>
                        <name>authorization</name>
                        <critical/>
                    </console>
                    <console>
                        <name>daemon</name>
                        <alert/>
                    </console>
                    <console>
                        <name>ftp</name>
                        <warning/>
                    </console>
                    <console>
                        <name>ntp</name>
                        <critical/>
                    </console>
                    <console>
                        <name>security</name>
                        <error/>
                    </console>
                    <console>
                        <name>kernel</name>
                        <any/>
                    </console>
                    <console>           
                        <name>user</name>
                        <info/>
                    </console>
                    <console>
                        <name>dfc</name>
                        <info/>
                    </console>
                    <console>
                        <name>external</name>
                        <none/>
                    </console>
                    <console>
                        <name>firewall</name>
                        <notice/>
                    </console>
                    <console>
                        <name>pfe</name>
                        <emergency/>
                    </console>
                    <console>
                        <name>conflict-log</name>
                        <error/>
                    </console>
                    <console>
                        <name>change-log</name>
                        <emergency/>
                    </console>
                    <console>
                        <name>interactive-commands</name>
                        <alert/>
                    </console>
                    <time-format>
                        <year/>
                        <millisecond/>  
                    </time-format>
                    <source-address>2.2.2.2</source-address>
                    <log-rotate-frequency>55</log-rotate-frequency>
                </syslog>
            </system>
    </configuration>
    <cli>
        <banner>[edit]</banner>
    </cli>
</rpc-reply>






<rpc-reply xmlns:junos="http://xml.juniper.net/junos/15.1X49/junos">
    <configuration junos:commit-seconds="1523858686" junos:commit-localtime="2018-04-16 06:04:46 UTC" junos:commit-user="admin">
            <system>
                <host-name>a.b</host-name>
                <root-authentication>
                    <encrypted-password>$5$inIahfe.$Qnr1MoWFgxM4kceZxzhJ.9MnUwW4zK.rSTQNyAqwSO.</encrypted-password>
                </root-authentication>
                <login>
                    <user>
                        <name>admin</name>
                        <uid>2000</uid>
                        <class>super-user</class>
                        <authentication>
                            <encrypted-password>$5$zPBYW7iT$kuuku/1RPFDpYHaYGmYG0yD.ioA2RUwv5Lim2yJj4H9</encrypted-password>
                        </authentication>
                    </user>
                </login>
                <services>
                    <ssh>
                    </ssh>
                    <web-management>
                        <http>
                            <interface>fxp0.0</interface>
                        </http>
                    </web-management>
                </services>
                <syslog>
                    <user>
                        <name>*</name>
                        <contents>
                            <name>any</name>
                            <emergency/>
                        </contents>
                    </user>
                    <host>              
                        <name>192.168.1.40</name>
                        <contents>
                            <name>any</name>
                            <notice/>
                        </contents>
                        <port>5514</port>
                        <log-prefix>$UUID</log-prefix>
                    </host>
                    <file>
                        <name>messages</name>
                        <contents>
                            <name>any</name>
                            <any/>
                        </contents>
                        <contents>
                            <name>authorization</name>
                            <info/>
                        </contents>
                    </file>
                    <file>
                        <name>interactive-commands</name>
                        <contents>
                            <name>interactive-commands</name>
                            <any/>
                        </contents>
                    </file>
                    <time-format>
                        <year/>
                    </time-format>
                </syslog>
                <license>
                    <autoupdate>
                        <url>
                            <name>https://ae1.juniper.net/junos/key_retrieval</name>
                        </url>
                    </autoupdate>
                </license>
            </system>
    </configuration>
    <cli>
        <banner>[edit]</banner>
    </cli>
</rpc-reply>
