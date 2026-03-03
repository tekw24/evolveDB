
# EvolveDB/EvolveGDB

This repository contains the source code and evolution datasets for EvolveDB and its extension EvolveGDB.

## EvolveDB
EvolveDB is an approach to model-driven schema evolution in relational databases, where the user specifies the evolution steps by freely editing a database model extracted by reverse engineering. EvolveDB analyzes the differences between the status quo and the evolved model structures and generates a data migration script. EvolveDB is currently available as an Eclipse Feature.
A screencast of the demo is available at [https://youtu.be/ieXmrDd2nw4](https://www.youtube.com/watch?v=k57NUi3blbg&t=7s). 

We also provide an end-user [end_user_documentation.pdf](https://github.com/tekw24/evolveDB/files/10188435/end_user_documentation.pdf) and a developer [developer_documentation.pdf](https://github.com/tekw24/evolveDB/files/10188441/developer_documentation.pdf) tutorial. The mysql dump files for the end-user tutorial are located in the [MySQL_dump_files.zip](MySQL_dump_files.zip) archive. 

![overview](https://user-images.githubusercontent.com/107031692/196974028-73149364-f3ab-4b09-a0bc-8e2d8a729de8.png)

We did an initial evaluation. We provide the details in the following document. [EvolveDB_Evaluation.pdf](https://github.com/tekw24/evolveDB/files/9854589/EvolveDB_Evaluation.pdf) 


If anything should be unclear or if you have questions, please do not hesitate to contact us.

The development of EvolveDB was supported by [StudiumPlus](https://www.studiumplus.de/sp/). StudiumPlus is part of the Technische Hochschule Mittelhessen (THM) and offers dual study programs. 

## EvolveGDB

EvolveGDB extends EvolveDb towards model-driven schema transformation for graph databases.


## Related Publications
For background, methodology, and evaluation details, please refer to the following publications:

EvolveDB: evolving relational database schemas in a model-driven way  
Software and Systems Modeling (SoSyM), 2025   
DOI: 10.1007/s10270-025-01341-x  

EvolveDB: a tool for model driven schema evolution  
MODELS (Companion), 2022  
DOI: 10.1145/3550356.3559095  

Model-Driven Schema Transformation for Graph Databases  
ER 2025 (Conceptual Modeling), LNCS  
DOI: 10.1007/978-3-032-08623-5_17  

How to Cite

If you use this repository, the datasets, or the tooling in academic work, please cite the relevant publication(s) above.

