import IStaff from "./IStaff"

interface IStaffContext{
    staff: IStaff[],
    getStaffById: (id: number) => Promise<IStaff | null>,
    getStaffByName: (firstname: string, lastname: string) => Promise<IStaff | null>
    postStaff: (newStaff: IStaff) => Promise<IStaff | null>,
    putStaff: (updatedStaff: IStaff) => Promise<IStaff | null>,
    deleteStaff: (id: number) => void
}

export default IStaffContext;