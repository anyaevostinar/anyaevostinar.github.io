#!/bin/bash --login

## This file runs one experimental condition (i.e. a group of jobs
## that are the same except for their random seed)

## Email settings (they don't work for our setup)
#SBATCH --mail-type=ALL
#SBATCH --mail-user=does_not_work@carleton.edu

## Job name settings (These do matter, so UPDATE THEM)
#SBATCH --job-name=sm-1k
#SBATCH -o sm-1k%A_%a.out

## Memory requirement in megabytes. You might need to make this bigger.
#SBATCH --mem-per-cpu=500M

## Launch an array of jobs. This determines your random seeds
#SBATCH --array=100-129

#SBATCH --nodes=1

cd /Accounts/YOUR_USERNAME/YOUR_GIT_REPO/Data/TODAY_DATE_YOUR_EXPERIMENT_FOLDER
mkdir YOUR_TREATMENT_NAME
cd YOUR_TREATMENT_NAME

mkdir ${SLURM_ARRAY_TASK_ID}
cd ${SLURM_ARRAY_TASK_ID}

cp /Accounts/YOUR_USERNAME/YOUR_GIT_REPO/Data/TODAY_DATE_YOUR_EXPERIMENT_FOLDER/SymSettings.cfg .
cp /Accounts/YOUR_USERNAME/YOUR_GIT_REPO/SymbulationEmp/symbulation_sgp .

## THIS IS AN EXAMPLE, UPDATE TO CORRECT THINGS
args=" -START_MOI 1 -FILE_NAME _YOUR_TREAMENT -SYMBIONT_TYPE 1 -VERTICAL_TRANSMISSION 1.0 -SAFE_TIME 1000 -DATA_INT 10 -UPDATES 5000 -EXTINCTION_FREQUENCY 200"
./symbulation_sgp $args -SEED ${SLURM_ARRAY_TASK_ID} > run.log

## Run with sbatch -p facultynode --nodelist=edmonstone2024,margulis2024,carver,lederberg YOUR_FILE_NAME.sh