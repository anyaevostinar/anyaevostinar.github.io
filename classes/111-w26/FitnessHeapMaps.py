# importing the modules
from random import randint
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt
  
#host_int_vals = [-1, -0.9, -0.8, -0.7, -0.6, -0.5, -0.4, -0.3, -0.2, -0.1, 0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0]
host_int_vals = [0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0]
#sym_int_vals = [-1, -0.9, -0.8, -0.7, -0.6, -0.5, -0.4, -0.3, -0.2, -0.1, 0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0]
sym_int_vals = [0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0]
host_int_vals.reverse()


host_res = []
sym_res = []
sym_repro = []
host_repro = []
synergy = 2
res_update = 100
horizontal_transmission_res = 100
#vertical_transmission_res = 0
#only works for free vertical transmission currently
host_reproduction_res = 1000
vertical_transmission_rate = 0.4
sym_age_limit = 50
host_age_limit = 100

#the chance of the symbiont offspring dying during horizontal transmission
#because most hosts are at sym_limit
horizontal_trans_death_rate = 0.75

for h in range(len(host_int_vals)):
    host_res.append([None] * len(sym_int_vals))
    sym_res.append([None] * len(sym_int_vals))
    for s in range(len(sym_int_vals)):
        if host_int_vals[h]>=0 and sym_int_vals[s] >= 0:
            host_donate = res_update * host_int_vals[h]
            host_resources = res_update - host_donate
            sym_donate = host_donate * sym_int_vals[s]
            sym_res[h][s] = host_donate - sym_donate
            host_res[h][s] = host_resources + sym_donate * synergy
        elif host_int_vals[h]<0 and sym_int_vals[s]<0:
            host_defense = res_update* -1 * host_int_vals[h]
            host_resources = res_update - host_defense

            #difference between sym magnitude and host magnitude
            diff = -1 * sym_int_vals[s] - -1 * host_int_vals[h]
            stolen = 0
            if diff > 0:
                #sym is more negative and so steals from host
                stolen = host_resources*diff
                host_resources -= stolen
            sym_res[h][s] = stolen
            host_res[h][s] = host_resources
        elif host_int_vals[h] <0 and sym_int_vals[s] >= 0:
            host_defense = res_update* -1 * host_int_vals[h]
            host_resources = res_update - host_defense
            sym_res[h][s] = 0
            host_res[h][s] = host_resources
        elif host_int_vals[h] >= 0 and sym_int_vals[s] < 0:
            #symbiont gets donated resources and steals more
            host_donate = res_update * host_int_vals[h]
            host_resources = res_update - host_donate
            stolen = -1 * sym_int_vals[s] * host_resources
            host_resources -= stolen
            sym_resources = host_donate + stolen
            sym_res[h][s] = sym_resources
            host_res[h][s] = host_resources
        else:
            print("Problem, this shouldn't happen")
  
# plotting the resources heatmap
# hm = sns.heatmap(data = host_res, xticklabels = sym_int_vals, yticklabels = host_int_vals)
  
for h in range(len(host_int_vals)):
    host_repro.append([None] * len(sym_int_vals))
    sym_repro.append([None] * len(sym_int_vals))
    for s in range(len(sym_int_vals)):
        h_res_update = host_res[h][s]
        #the resetting points to zero makes the below slightly inaccurate
        total_lifetime_res = h_res_update * host_age_limit
        total_offspring = int(total_lifetime_res/host_reproduction_res)
        host_repro[h][s] = total_offspring

        s_res_update = sym_res[h][s]
        #this section will need to be updated for costly vertical transmission
        s_total_lifetime = s_res_update * sym_age_limit
        s_total_offspring = s_total_lifetime//horizontal_transmission_res
        s_total_offspring = int(s_total_offspring *(1-horizontal_trans_death_rate))
        s_total_offspring += int(total_offspring * vertical_transmission_rate)
        sym_repro[h][s] = s_total_offspring

hm = sns.heatmap(data = sym_repro, xticklabels = sym_int_vals, yticklabels = host_int_vals, annot=True)



# displaying the plotted heatmap
plt.show()