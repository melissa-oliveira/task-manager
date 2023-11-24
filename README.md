# Gerenciador de Tarefas - Trabalho Final de LPOO2

Este é o repositório do trabalho final da disciplina de Linguagem de Programação Orientada a Objetos 2 (LPOO2). O objetivo deste projeto é criar um robusto Gerenciador de Tarefas que utiliza as tecnologias AngularJS, Spring Tools, APIs RESTful e PostgreSQL para fornecer uma solução eficiente que implementa de forma eficiênte o paradigma de orientação á objetos.

## Tecnologias Utilizadas
- **AngularJS:** Utilizado para construir a interface do usuário dinâmica e interativa.
- **Spring Tools:** Utilizado para desenvolver a camada de backend da aplicação, proporcionando um ambiente eficaz para a criação de APIs RESTful.
- **APIs RESTful:** Implementadas para comunicação entre o frontend e o backend, garantindo uma arquitetura flexível e desacoplada.
- **PostgreSQL:** Banco de dados relacional utilizado para armazenar e gerenciar os dados da aplicação de forma persistente.

## Estrutura do Projeto
O projeto é composto por classes e entidades principais que desempenham papéis cruciais no gerenciamento de tarefas. As classes/entidades principais são:

### 1. TaskCategory
```typescript
export class TaskCategory {
    constructor(
        public id: number,
        public name: string,
        public description: string,
        public color?: string
    ) { }
}
```

### 2. TaskState
```typescript
export class TaskState {
    constructor(
        public id: number,
        public name: string,
        public description: string
    ) { }
}
```

### 3. User
```typescript
import { Task } from "./task.model";

export class User {
    constructor(
        public id: number,
        public name: string,
        public email: string,
        public password: string,
        public taskList?: Task[]
    ) { }
}
```

### 4. Task
```typescript
import { TaskCategory } from "./task-category.model";
import { TaskState } from "./task-state.model";
import { User } from "./user.model";

export class Task {
    constructor(
        public id: number,
        public title: string,
        public description: string,
        public dueDate: Date,
        public completed: boolean,
        public responsible: User,
        public priority: number,
        public state: TaskState,
        public category: TaskCategory
    ) { }
}
```

## Execução do Projeto
Para executar o projeto, siga os passos abaixo:

1. **Frontend (AngularJS):**
   - Navegue até o diretório do frontend.
   - Execute o comando para instalar as dependências: `npm install`.
   - Inicie a aplicação: `ng serve`.

2. **Backend (Spring Tools):**
   - Importe o projeto no Spring Tools.
   - Configure o banco de dados PostgreSQL.
   - Execute a aplicação.

--- 

**Equipe: Melissa Silva de Oliveira**

**Instituição de Ensino: UFPR - Univerdade Federal do Paraná**

**Curso: TADS - Tecnologia em Análise e Desenvolvimento de Sistemas**

**Ano/Semestre: 2023/2° Semestre**
