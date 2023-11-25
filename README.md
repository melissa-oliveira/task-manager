# Gerenciador de Tarefas - Trabalho Final de LPOO2

Este é o repositório do trabalho final da disciplina de Linguagem de Programação Orientada a Objetos 2 (LPOO2). O objetivo deste projeto é criar um robusto Gerenciador de Tarefas que utiliza as tecnologias AngularJS, Spring Tools, APIs RESTful e PostgreSQL para fornecer uma solução eficiente que implementa de forma eficiênte o paradigma de orientação á objetos.

## Tecnologias Utilizadas
- **AngularJS:** Utilizado para construir a interface do usuário dinâmica e interativa.
- **Spring Tools:** Utilizado para desenvolver a camada de backend da aplicação, proporcionando um ambiente eficaz para a criação de APIs RESTful.
- **APIs RESTful:** Implementadas para comunicação entre o frontend e o backend, garantindo uma arquitetura flexível e desacoplada.
- **PostgreSQL:** Banco de dados relacional utilizado para armazenar e gerenciar os dados da aplicação de forma persistente.

## Estruturas das Classes em Java

### 1. Entity Classes

As classes de entidade em Java representam objetos persistentes armazenados no banco de dados. Geralmente, são anotadas com `@Entity` e mapeadas para tabelas no banco de dados. No contexto do projeto, as classes `TaskCategory`, `TaskState`, `User`, e `Task` podem ser consideradas entidades.

Exemplo de uma entidade usando a anotação `@Entity`:
```java
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskCategory {

    // tributos, construtores, getters e setters
}
```

### 2. Controller Classes

Os controladores em Java, geralmente anotados com `@Controller` ou `@RestController` no contexto do Spring, gerenciam as requisições HTTP e interagem com os serviços para processar e devolver dados. Eles atuam como intermediários entre o frontend e o backend.

Exemplo de um controlador utilizando `@RestController`:
```java
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    
    // Métodos para manipulação de tarefas
}
```

### 3. Service Classes

As classes de serviço em Java, geralmente anotadas com `@Service`, contêm a lógica de negócios da aplicação. Elas interagem com as classes de entidade e o repositório para realizar operações específicas.

Exemplo de uma classe de serviço:
```java
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    // Métodos de serviço
}
```

### 4. Repository Interface

As interfaces de repositório estendendo `JpaRepository` são usadas para realizar operações de persistência no banco de dados. Elas fornecem métodos predefinidos para operações comuns, além de permitir a criação de consultas personalizadas.

Exemplo de uma interface de repositório:
```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // Métodos de repositório
}
```

## Funções Lambda e Streams

As funções lambda e streams são recursos poderosos introduzidos no Java 8. As funções lambda permitem expressar instâncias de interfaces funcionais de forma concisa. Streams proporcionam uma maneira de processar sequências de elementos de forma declarativa.

Exemplo de uma função lambda:
```java
List<Task> highPriorityTasks = tasks.stream()
    .filter(task -> task.getPriority() > 5)
    .collect(Collectors.toList());
```

Exemplo de uso de streams:
```java
int sumOfPriorities = tasks.stream()
    .mapToInt(Task::getPriority)
    .sum();
```

## Processamento Paralelo no Banco de Dados

O Spring gerencia o controle transacional por meio de proxies. Quando um método anotado com `@Transactional` é chamado, o Spring inicia uma transação, e ao sair do método, a transação é commitada. Se ocorrer uma exceção, a transação é revertida.

## Estrutura das Classes em Angular

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
