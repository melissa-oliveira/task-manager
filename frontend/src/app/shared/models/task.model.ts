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
