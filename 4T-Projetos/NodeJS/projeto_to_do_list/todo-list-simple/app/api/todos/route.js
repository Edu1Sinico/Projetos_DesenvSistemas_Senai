import connectMongo from '@/utils/mongodb';
import Todo from '@/models/Todo';
import { NextResponse } from 'next/server';

// Get
export async function GET() {
  await connectMongo();
  try {
    const todos = await Todo.find({});
    return NextResponse.json({ success: true, data: todos });
  } catch (error) {
    return NextResponse.json({ success: false }, { status: 400 });
  }
}

// Create
export async function POST(req) {
  await connectMongo();
  try {
    const data = await req.json();
    const todo = await Todo.create(data);
    return NextResponse.json({ success: true, data: todo });
  } catch (error) {
    return NextResponse.json({ success: false }, { status: 400 });
  }
}
